package cracking.ch04;

public class TreeNode {
    public TreeNode rightChild = null;
    public TreeNode leftChild = null;
    public int data;

    public TreeNode (int data) {
        this.data = data;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
