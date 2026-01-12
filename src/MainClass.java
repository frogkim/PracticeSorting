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

        int[] bubbleSort = unsorted.clone();
        bubbleSort(bubbleSort);
        System.out.println("Check Bubble Sort");
        Compare(bubbleSort, sorted, nSampleSize);

    }

    static public void bubbleSort(int[] unsorted) {
        // 코드


    }

    static public void Compare(int[] unsorted, int[] sorted, int nSampleSize) {
        boolean flag = true;
        for(int i = 0; i < nSampleSize; i++){
            if(unsorted[i] != sorted[i]){
                System.out.printf("Failed at %d\n", i);
                flag = false;
            }
        }
        if(flag){
            System.out.println("Your array is sorted");
        } else {
            System.out.println("Your array is not sorted");
        }
    }


}
