package cracking.ch04.ten;

import cracking.ch04.Node;
import cracking.ch04.TreeNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * CheckSubTreeTest
 *
 * @author jongUn
 * @since 2017. 11. 09.
 */
public class CheckSubTreeTest {
	private CheckSubTree checkSubTree = new CheckSubTree();

	@Test
	public void check() throws Exception {
		// given
		TreeNode head = makeBalancedTree();
		TreeNode subHead = makeSubTree();

		// when
		boolean result = checkSubTree.check(head, subHead);

		// then
		assertThat(result, is(true));
	}

	@Test
	public void check_fail() throws Exception {
		// given
		TreeNode head = makeBalancedTree();
		TreeNode subHead = makeNotSubTree();

		// when
		boolean result = checkSubTree.check(head, subHead);

		// then
		assertThat(result, is(false));
	}

	private TreeNode makeBalancedTree() {
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);

		node5.leftChild = node3;
		node5.rightChild = node7;

		node3.leftChild = node2;
		node3.rightChild = node4;

		node7.leftChild = node6;
		node7.rightChild = node8;

		return node5;
	}

	private TreeNode makeSubTree() {
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);

		node7.leftChild = node6;
		node7.rightChild = node8;

		return node7;
	}

	private TreeNode makeNotSubTree() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		node1.leftChild = node2;
		node1.rightChild = node3;

		return node1;
	}

}