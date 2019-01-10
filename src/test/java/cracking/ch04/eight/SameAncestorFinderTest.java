package cracking.ch04.eight;

import cracking.ch04.TreeNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SameAncestorFinderTest {

    private SameAncestorFinder sameAncestorFinder;
    private TreeNode firstNode;
    private TreeNode secondNode;

    public SameAncestorFinderTest() {
        this.sameAncestorFinder = new SameAncestorFinder();
    }

    @Test
    public void find_부모로가는루트가있는경우() {
        // given
        TreeNode head = makeTreeWithParents();

        // when
        TreeNode result = sameAncestorFinder.findOnHasParentPath(head, firstNode, secondNode);

        // then
        assertThat(result.data, is(1));
    }

    @Test
    public void findOnHasParentPath2() {
        // given
        TreeNode head = makeTreeWithParents();

        // when
		TreeNode result = sameAncestorFinder.findOnHasParentPath2(head, firstNode, secondNode);

        // then
        assertThat(result.data, is(1));
    }

    @Test
    public void find_부모로가는루트가없는경우() {
        // given
        TreeNode head = makeTree();

        // when
        TreeNode result = sameAncestorFinder.find(head, firstNode, secondNode);

        // then
        assertThat(result.data, is(1));
    }


    private TreeNode makeTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.leftChild = node2;
        node1.rightChild = node3;

        node2.leftChild = node4;
        node2.rightChild = node5;

        node3.leftChild = node6;
        node3.rightChild = node7;

        node4.leftChild = node8;

        firstNode = node2;
        secondNode = node6;

        return node1;
    }

    private TreeNode makeTreeWithParents() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.leftChild = node2;
        node1.rightChild = node3;
        node2.parent = node1;
        node3.parent = node1;

        node2.leftChild = node4;
        node2.rightChild = node5;
        node4.parent = node2;
        node5.parent = node2;

        node3.leftChild = node6;
        node3.rightChild = node7;
        node6.parent = node3;
        node7.parent = node3;

        node4.leftChild = node8;
        node8.parent = node4;

        firstNode = node2;
        secondNode = node6;

        return node1;
    }
}