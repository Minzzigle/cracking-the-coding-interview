package cracking.pre;

public class InsertionSort {

    public void sort(int [] arr) {
        if(arr.length == 0) {
            return;
        }

        for(int i = 1; i<arr.length; i++) {
            int current = arr[i];
            for(int j = i - 1; j >= 0; j--) {
                if(current < arr[j]) {
                    swap(arr, i, j);
                    break;
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }
}
