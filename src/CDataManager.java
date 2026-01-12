import java.io.*;
import java.util.Random;
import java.util.*;

public class CDataManager {
    private final int m_nData;
    private final int m_nDuplicateFactor;
    private final String m_fileName;
    private final CDataConvert m_DataConvert;

    public CDataManager(int nData, int nDuplicateFactor) {
        m_nData = nData;
        m_nDuplicateFactor = nDuplicateFactor;
        m_fileName = SampleLoader.path;
        m_DataConvert = new CDataConvert();
    }

    public void Process() {
        int[] unsorted = GetRandomInts(m_nData, m_nDuplicateFactor);
        int[] sorted = unsorted.clone();
        Arrays.sort(sorted);

        for(int i = 1; i < unsorted.length; i++) {
            if(unsorted[i-1] > unsorted[i]) {
                System.out.println("Success!");
                break;
            }
        }

        for(int i = 1; i < sorted.length; i++) {
            if(sorted[i-1] > sorted[i]) {
                System.out.println("Failed!");
                return;
            }
        }
        System.out.println("Works!");
        int[] arr = new int[m_nData * 2 + 1];

        int end = m_nData + 1;
        arr[0] = m_nData;
        for(int i = 0, j = 1; j < end; i++, j++) {
            arr[j] = unsorted[i];
        }
        end += m_nData;
        for(int i = 0, j = m_nData + 1; j < end; i++, j++) {
            arr[j] = sorted[i];
        }
        WriteDataToFile(arr);
    }

    public int[] GetRandomInts(int nSampleSize, int duplicateFactor) {
        Random r = new Random();
        int[] arr = new int[nSampleSize];
        int min = - (nSampleSize / 2);
        for (int i = 0; i < nSampleSize; i++) {
            arr[i] = r.nextInt(nSampleSize - duplicateFactor) + min;       // for duplicate numbers
        }
        return arr;
    }

    public void WriteDataToFile(int[] arr) {
        CDataConvert DataConvert = new CDataConvert();
        try(OutputStream outstream  = new FileOutputStream(m_fileName)) {
            byte[] data = DataConvert.IntsToBytes(arr);
            outstream.write(data);
            System.out.println("Data written to the file successfully.");
        }
        catch(IOException e) {
            System.out.println("Failed to open a file.");
        }
    }

    public int[] ReadDataFromFile() {
        final int buffer_size = (m_nData * 4)  * 2;                    // byte * 4 = int, + 4 bytes for header
        byte[] buffer = new byte[buffer_size];
        int res, size;
        int[] arr = new int[0];

        try(InputStream instream = new FileInputStream(m_fileName)) {
            size = instream.read(buffer, 0, 4);
            if(size == 0) {
                return arr;
            }
            size = m_DataConvert.ByteToInt(buffer);
            res = instream.read(buffer, 0, size * 4 * 2);
            arr = m_DataConvert.BytesToInts(buffer, res);
            System.out.println("Success to read\n");
        } catch (IOException e) {
            System.out.println("Failed to read");
        }
        return arr;
    }
}
