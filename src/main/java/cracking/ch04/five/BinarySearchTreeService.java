package cracking.ch04.five;

import cracking.ch04.Node;

public class BinarySearchTreeService {
    public boolean check(Node head) {
        int result = checkBinaryTree(head, true);

        if(result == Integer.MIN_VALUE) {
            return false;
        }

        return true;
    }

    private int checkBinaryTree(Node head, boolean isRight) {
        if(head == null) {
            if(isRight) {
                return Integer.MAX_VALUE;
            } else {
                return -1;
            }
        }

        int biggestLeft = checkBinaryTree(head.children[0], false);

        if(biggestLeft == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int smallestRight = checkBinaryTree(head.children[1], true);

        if(smallestRight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int currentValue = head.value;

        if(biggestLeft > currentValue) {
            return Integer.MIN_VALUE;
        }

        if(currentValue > smallestRight) {
            return Integer.MIN_VALUE;
        }

        if(isRight) {
            return Math.min(Math.min(biggestLeft, smallestRight), currentValue);
        } else {
            return Math.max(Math.max(biggestLeft, smallestRight), currentValue);
        }
    }
}
