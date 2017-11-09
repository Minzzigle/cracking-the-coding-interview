package cracking.ch04.five;

import cracking.ch04.TreeNode;

public class RightBST {
    public int checkBST (TreeNode root){
        if (root == null) {
            return 0;
        }

        TreeNode leftChild = root.getLeftChild();
        int currentData = root.getData();
        if (leftChild.getData() > currentData) {
            return -1;
        }

        TreeNode rightChild = root.getRightChild();
        if (rightChild.getData() < currentData) {
            return -1;
        }

        int leftResult = checkBST(leftChild);
        int rightResult = checkBST(rightChild);

        if (leftResult < 0 || rightResult < 0) {
            return -1;
        }
        return 0;
    }
}
