package cracking.pre;

public class SelectionSort {

    public void sort(int [] arr) {
        if(arr.length == 0) {
            return;
        }

        for(int i = 0; i<arr.length; i++) {
            int smallIdx = findMinIdx(arr, i, arr.length);
            swap(arr, i, smallIdx);
        }

    }

    private void swap(int[] arr, int i, int smallIdx) {
       int temp = arr[i];
       arr[i] = arr[smallIdx];
       arr[smallIdx] = temp;
    }

    private int findMinIdx(int[] arr, int start, int end) {

        Integer smallestIdx = null;
        for(int i = start; i< end; i++) {
            int current = arr[i];
            if(smallestIdx == null) {
                smallestIdx = i;
            } else {
                if(current < arr[smallestIdx]) {
                    smallestIdx = i;
                }
            }
        }

        return smallestIdx;
    }

}
