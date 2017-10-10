package cracking.ch04.two;

import cracking.ch04.Node;

public class BalancedTree {
    public Node make(int [] arr) {
        if(arr.length == 0) {
            return null;
        }

        int mid = (arr.length - 1) / 2;
        Node n = new Node(String.valueOf(arr[mid]));
        int [] leftArr = split(arr, 0, mid-1);
        int [] rightArr = split(arr, mid+1, arr.length - 1);

        Node left = make(leftArr);
        Node right = make(rightArr);
        n.children = new Node[]{left, right};

        return n;
    }

    private int[] split(int[] arr, int start, int end) {
        int [] result = new int[end - start + 1];
        int idx = 0;

        for(int i = start; i<=end; i++) {
            result[idx] = arr[i];
            idx++;
        }

        return result;
    }
}
