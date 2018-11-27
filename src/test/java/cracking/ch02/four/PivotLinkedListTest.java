package cracking.ch02.four;

import cracking.ch02.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * PivotLinkedListTest
 *
 * @author jongUn
 * @since 2018. 11. 26.
 */
public class PivotLinkedListTest {

	private PivotLinkedList pivotLinkedList;

	@Before
	public void setUp() {
		pivotLinkedList = new PivotLinkedList();
	}

	@Test
	public void split() {
		// given
		Node input = makeNode();
		int standard = 5;

		// when
		Node result = pivotLinkedList.split(input, standard);

		// then
		assertResult(result, standard);
	}

	@Test
	public void splitByOneList() {
		// given
		Node input = makeNode();
		int standard = 5;

		// when
		Node result = pivotLinkedList.splitByOneList(input, standard);

		// then
		assertResult(result, standard);
	}

	private void assertResult(Node result, int standard) {
		if(result == null) {
			return;
		}

		boolean found = false;

		while(result != null) {
			if(result.data == standard && found == false) {
				found = true;
			}else if(found == false) {
				assertTrue(result.data < standard);
			} else {
				assertTrue(result.data >= standard);
			}

			result = result.next;
		}
	}

	private Node makeNode() {
		Node node = new Node(3);
		Node node1 = new Node(5);
		Node node2 = new Node(8);
		Node node3 = new Node(5);
		Node node4 = new Node(10);
		Node node5 = new Node(2);
		Node node6 = new Node(1);

		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		return node;
	}
}