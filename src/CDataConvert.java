public class CDataConvert {
    public int ByteToInt(byte[] src) {
        if(src.length < 4) {
            return 0;
        }
        return (src[0] & 0x000000FF)
                | ((src[1] & 0x000000FF) << 8)
                | ((src[2] & 0x000000FF) << 16)
                | ((src[3] & 0x000000FF) << 24);
    }


    public int[] BytesToInts(final byte[] src, int src_size) {
        int size = src_size / 4;
        int residual = src_size % 4;
        int[] ret;
        if(residual > 0) {
            ret = new int[size + 1];
        } else {
            ret = new int[size];
        }
        int i = 0, j = 0, end = size;
        while(i < end){
            ret[i] = (src[j] & 0x000000FF)
                    | ((src[j+1] & 0x000000FF) << 8)
                    | ((src[j+2] & 0x000000FF) << 16)
                    | ((src[j+3] & 0x000000FF) << 24);
            i++;
            j+=4;
        }
        if(residual > 1) {
            for(int k = 0; k < residual; k++) {
                ret[i] = ret[i] | (src[j+k] << 24 - 8*k);
            }
        }
        return ret;
    }

    public byte[] IntsToBytes(final int[] src) {
        byte[] ret = new byte[src.length * 4];
        for(int i = 0, j = 0; i < src.length; i++, j+=4) {
            ret[j  ] = (byte) (src[i]      );
            ret[j+1] = (byte) (src[i] >>  8);
            ret[j+2] = (byte) (src[i] >> 16);
            ret[j+3] = (byte) (src[i] >> 24);
        }
        return ret;
    }
}
