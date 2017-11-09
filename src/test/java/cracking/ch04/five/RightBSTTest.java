package cracking.ch04.five;

import cracking.ch04.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RightBSTTest {
    RightBST bst = new RightBST();

    private TreeNode bst () {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(10);
        TreeNode g = new TreeNode(1);
        root.setLeftChild(a);
        root.setRightChild(b);
        a.setLeftChild(c);
        a.setRightChild(d);
        b.setLeftChild(e);
        b.setRightChild(f);
        c.setLeftChild(g);
        return root;
    }

    @Test
    public void checkBST() throws Exception {
        RightBST bst = new RightBST();
        assertEquals(0, bst.checkBST(bst()));
    }

}