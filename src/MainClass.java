public class MainClass {

    static public void main(String[] args) {
        int[] arr = SampleLoader.GetArray();
        int[] unsorted = SampleLoader.GetUnsorted(arr);
        int[] sorted = SampleLoader.GetSorted(arr);
        int nSamples = SampleLoader.nSampleSize;
        // unsorted 와 sorted 에 각각 10만개의 샘플이 들어있습니다.
        // unsorted 는 정렬되지 않는 것, sorted 는 오름차순 정렬된 것입니다.
        // 범위는 -5만 ~ +5만 입니다.
        // 중복된 값이 존재합니다.

        YourFunc(unsorted, sorted, nSamples);


        // Hold x to pay respect
        System.out.println("Hello Frog!");
    }

    static public void YourFunc(int[] unsorted, int[] sorted, int nSampleSize) {
        // Make your logic in here

    }


}
