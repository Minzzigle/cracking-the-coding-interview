package cracking.ch16.six;

import java.util.Arrays;

/**
 * 두 개의 배열이 주어져 있을 때, 두 배열의 값 중 가장 절댓값의 차가 작은 두 값을 찾아 반환한다.
 * {1,3,5,11,2}, {23,127,235,19,8} => {11, 8} => 3
 */
public class AbsTwoArray {

    /**
     *  1. 한 배열을 정렬한다.
     *  2. 두 번째 배열의 원소를 순회하면서 이진탐색을 통해 해당 원소의 위치를 찾는다.
     *  3. 원소가 있다면 값을 빼서 반환한다. (0이므로 가장 작다)
     *  4. 없다면 해당 인덱스 앞뒤의 두 값을 빼서, 현재까지 나온 값 중 가장 차가 작은 값인지 확인한다. 작다면 업데이트하고, 크다면 업데이트하지 않는다.
     *  5. 응답값을 반환한다.
     *
     *  각 배열의 길이를 a,b라 하였을 때 Time Complexity : O(aloga + bloga), Space Complexity : O(1)
     */
    public int calculate(int [] a, int [] b) {
        if(a == null || b == null) {
            return 0;
        }

        Arrays.sort(a);

        int result = Integer.MAX_VALUE;

        for(int each : b) {
            int idx = binarySearch(a, 0, a.length - 1, each);

            if(a[idx] == each) {
                return 0;
            }

            if(idx == 0) {
                int nowData = Math.abs(a[idx] - each);
                result = Math.min(result, nowData);
            } else {
                result = Math.min(Math.min(Math.abs(a[idx] - each), Math.abs(a[idx - 1] - each)), result);
            }
        }

        return result;
    }

    private int binarySearch(int[] a, int startIdx, int endIdx, int each) {
        if(startIdx > endIdx) {
            return startIdx;
        }

        int mid = (startIdx + endIdx) / 2;

        if(a[mid] == each) {
            return mid;
        } else if(a[mid] > each){
            return binarySearch(a, startIdx, mid - 1, each);
        } else {
            return binarySearch(a, mid + 1, startIdx, each);
        }
    }
}
