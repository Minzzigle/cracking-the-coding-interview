package cracking.ch04.ten;

import cracking.ch04.Node;
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
		Node head = makeBalancedTree();
		Node subHead = makeSubTree();

		// when
		boolean result = checkSubTree.check(head, subHead);

		// then
		assertThat(result, is(true));
	}

	@Test
	public void check_fail() throws Exception {
		// given
		Node head = makeBalancedTree();
		Node subHead = makeNotSubTree();

		// when
		boolean result = checkSubTree.check(head, subHead);

		// then
		assertThat(result, is(false));
	}

	private Node makeBalancedTree() {
		Node node2 = new Node("2", 2);
		Node node3 = new Node("3", 3);
		Node node4 = new Node("4", 4);
		Node node5 = new Node("5", 5);
		Node node6 = new Node("6", 6);
		Node node7 = new Node("7", 7);
		Node node8 = new Node("8", 8);

		node5.children = new Node[]{node3, node7};
		node3.children = new Node[]{node2, node4};
		node7.children = new Node[]{node6, node8};

		return node5;
	}

	private Node makeSubTree() {
		Node node6 = new Node("6", 6);
		Node node7 = new Node("7", 7);
		Node node8 = new Node("8", 8);

		node7.children = new Node[]{node6, node8};

		return node7;
	}

	private Node makeNotSubTree() {
		Node node1 = new Node("1", 1);
		Node node2 = new Node("2", 2);
		Node node3 = new Node("3", 3);

		node1.children = new Node[]{node2, node3};

		return node1;
	}

}