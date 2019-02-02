package cracking.ch04.five;

import cracking.ch04.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RightBSTTest {
    private RightBST bst;

    @Before
    public void setUp() {
        bst = new RightBST();
    }

    private TreeNode makeBST () {
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

    private TreeNode makeWrongBST () {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(10);
        TreeNode g = new TreeNode(11);
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
    public void checkBST() {
        assertThat(true, is(bst.isBSTWithInorderTraversal(makeBST())));
    }

    @Test
    public void checkBST_BST가아닌경우() {
        // given

        // when
        boolean result= bst.isBSTWithInorderTraversal(makeWrongBST());

        // then
        assertThat(result, is(false));
    }

    @Test
    public void checkBST_Root로NULL이들어오는경우() {
        // given

        // when
        boolean result = bst.isBSTWithInorderTraversal(null);

        // then
        assertThat(result, is(true));
    }

    @Test
    public void isBSTWITHRecursive_BST인경우() {
        // given

        // when
        boolean result = bst.isBSTWithRecursive(makeBST(), null, null);

        // then
        assertThat(result, is(true));
    }

    @Test
    public void isBSTWITHRecursive_BST가아닌경우() {
        // given

        // when
        boolean result = bst.isBSTWithRecursive(makeWrongBST(), null, null);

        // then
        assertThat(result, is(false));
    }
}