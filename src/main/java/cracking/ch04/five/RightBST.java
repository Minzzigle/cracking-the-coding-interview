package cracking.ch04.five;

import cracking.ch04.TreeNode;

public class RightBST {

    private Integer pre = null;

    public boolean isBSTWithInorderTraversal(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean leftResult = isBSTWithInorderTraversal(root.leftChild);

        if(pre == null) {
            pre = root.data;
        } else if(root.data < pre){
            return false;
        } else {
            pre = root.data;
            return true;
        }

        boolean rightResult = isBSTWithInorderTraversal(root.rightChild);

        return leftResult && rightResult;
    }

    public boolean isBSTWithRecursive(TreeNode root, Integer minimum, Integer maximum) {
        if(root == null) {
            return true;
        }

        if(minimum != null && minimum > root.data) {
            return false;
        }

        if(maximum != null && maximum < root.data) {
            return false;
        }

        return isBSTWithRecursive(root.leftChild, minimum, root.data) && isBSTWithRecursive(root.rightChild, root.data, maximum);
    }
}
