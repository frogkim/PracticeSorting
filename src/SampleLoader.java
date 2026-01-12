public class SampleLoader {
    static final public String path = "./resources/test.bin";
    static final public int nSampleSize = 100000;
    static final public int nDuplicateFactor = 1000;

    static int[] GetArray() {
        CDataManager DataManager = new CDataManager(nSampleSize, nDuplicateFactor);
        int[] arr = DataManager.ReadDataFromFile();
        return arr;
    }

    static int[] GetUnsorted(int[] arr) {
        int[] unsorted = new int[nSampleSize];
        for(int i = 0; i < nSampleSize; i++) {
            unsorted[i] = arr[i];
        }
        return unsorted;
    }

    static int[] GetSorted(int[] arr) {
        int[] sorted = new int[nSampleSize];
        int end = nSampleSize * 2;
        for(int i = 0, j = nSampleSize; j < end; i++, j++) {
            sorted[i] = arr[j];
        }
        return sorted;
    }
}
