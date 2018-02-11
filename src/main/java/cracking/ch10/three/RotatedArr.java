package cracking.ch10.three;

import java.util.List;

public class RotatedArr {

    // 3 6 7 10 14 100 1 2
    // 4 4 4 1 2 4 4 이러면 답은 뭐냐옹
    //이진 탐색 해본다

    public int binarySearch(List<Integer> arr, int target) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }

        int head = arr.get(0);
        int mid = arr.get(arr.size()/2);
        int nextmid = arr.get(arr.size()/2 + 1);

        if (target > head || target < mid) {
            return binarySearch(halfOfArr(arr),target);
        } else if (target < nextmid ) {
            return binarySearch(lastHalfArr(arr), target);
        } else {
            return target;
        }

        return 0;
    }

    private List<Integer> lastHalfArr(List<Integer> arr) {
        return null;
    }

    private List<Integer> halfOfArr(List<Integer> arr) {
        return null;
    }

}