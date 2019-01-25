package cracking.ch04.four;

import cracking.ch04.Node;
import cracking.ch04.three.NodeConnect;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * TreeDepthTest
 *
 * @author jongUn
 * @since 2017. 10. 20.
 */
public class TreeDepthTest {
	private TreeDepth treeDepth = new TreeDepth();

	@Before
	public void before() {

	}

	@Test
	public void checkBalanced_false() {
		// given
		Node head = makeUnbalancedTree();

		// when
		boolean result = treeDepth.checkBalanced(head);

		// then
		assertThat(result, is(false));
	}

	@Test
	public void checkBalanced_true() {
		// given
		Node head = makeBalancedTree();

		// when
		boolean result = treeDepth.checkBalanced(head);

		// then
		assertThat(result, is(true));
	}

	private Node makeUnbalancedTree() {
		Node node1 = new Node("1");
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		Node node8 = new Node("8");
		Node node9 = new Node("9");

		node1.children = new Node[]{node2, node3};
		node2.children = new Node[]{node4, node5};
		node3.children = new Node[]{node6, node7};
		node4.children = new Node[]{node8, null};
		node8.children = new Node[]{node9, null};

		return node1;
	}

	private Node makeBalancedTree() {
		Node node1 = new Node("1");
		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		Node node8 = new Node("8");

		node1.children = new Node[]{node2, node3};
		node2.children = new Node[]{node4, node5};
		node3.children = new Node[]{node6, node7};
		node4.children = new Node[]{node8, null};

		return node1;
	}

	@Test
	public void isBalancedTree_트리가균형잡힌경우() {
		// given

		// when
		boolean result = treeDepth.isBalancedTree(makeBalancedTree());

		// then
		assertThat(result, is(true));
	}

	@Test
	public void isBalancedTree_트리가균형잡히지않은경우() {
		// given

		// when
		boolean result = treeDepth.isBalancedTree(makeUnbalancedTree());

		// then
		assertThat(result, is(false));
	}
}