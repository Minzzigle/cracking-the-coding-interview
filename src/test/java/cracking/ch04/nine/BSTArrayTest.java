package cracking.ch04.nine;

import cracking.ch04.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * BSTArrayTest
 *
 * @author jongUn
 * @since 2017. 11. 10.
 */
public class BSTArrayTest {
	private BSTArray bstArray = new BSTArray();

	@Test
	public void solve() throws Exception {
		// given
		Node head = makeTree();

		// when
		ArrayList<LinkedList<Integer>> result = bstArray.solve(head);

		// then
		for(int i = 0; i<result.size(); i++) {
			LinkedList<Integer> target = result.get(i);
			printLinkedList(target);
		}
	}

	private Node makeTree() {
		Node node1 = new Node("1", 1);
		Node node2 = new Node("2", 2);
		Node node3 = new Node("3", 3);
		Node node4 = new Node("4", 4);
		Node node5 = new Node("5", 5);
		Node node6 = new Node("6", 6);
		Node node7 = new Node("7", 7);

		node1.children = new Node[]{node2, node3};
		node2.children = new Node[]{node4, node5};
		node3.children = new Node[]{node6, node7};

		return node1;
	}

	@Test
	public void weaveLists() throws Exception {
		// given
		LinkedList<Integer> first = new LinkedList<>();
		first.add(1);
		first.add(2);
		LinkedList<Integer> second = new LinkedList<>();
		second.add(3);
		second.add(4);
		ArrayList<LinkedList<Integer>> result = new ArrayList<>();
		LinkedList<Integer> prefix = new LinkedList<>();

		// when
		bstArray.weaveLists(first, second, result, prefix);

		// then
		for(int i = 0; i<result.size(); i++) {
			LinkedList<Integer> target = result.get(i);
			printLinkedList(target);
		}

	}

	private void printLinkedList(LinkedList<Integer> target) {
		while(!target.isEmpty()) {
			System.out.print(target.removeFirst() + " ");
		}
		System.out.println();
	}

}