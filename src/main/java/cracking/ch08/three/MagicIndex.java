package cracking.ch08.three;

/**
 * MagicIndex
 * 배열 arr가 존재할 때, arr[i] = i 인 i를 magic index 라고 한다.
 * magic index를 찾아 리턴하는 find 함수 작업.
 * arr에 같은 값이 존재할 때는 제대로 동작하지 않는다.
 *
 * @author jongUn
 * @since 2018. 01. 10.
 */
public class MagicIndex {
	public int find(int [] arr, int start, int end) {
		if(start > end) {
			return Integer.MIN_VALUE;
		}
		int mid = (start + end) / 2;
		if(arr[mid] > mid) {
			return find(arr, start, mid-1);
		} else if(arr[mid] < mid) {
			return find(arr, mid+1, end);
		} else {
			return mid;
		}
	}

}
