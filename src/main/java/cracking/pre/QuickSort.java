package cracking.pre;

/**
 * QuickSort
 *
 * @author jongUn
 * @since 2018. 07. 20.
 */
public class QuickSort {
	public void sort(int [] arr, int start, int end) {
		if(start < end) {
			int pivot = findPivot(arr, start, end);
			sort(arr, start, pivot - 1);
			sort(arr, pivot + 1, end);
		}
	}

	private int findPivot(int[] arr, int start, int end) {
		int boundaryOfLow = start;
		int pivot = arr[end];

		for(int i = start; i<end; i++) {
			if(arr[i] < pivot) {
				swap(arr, ++boundaryOfLow, i);
			}
		}

		swap(arr, boundaryOfLow, end);

		return boundaryOfLow;
	}

	private void swap(int[] arr, int i, int j) {
		int pre = arr[i];
		arr[i] = arr[j];
		arr[j] = pre;
	}

}
