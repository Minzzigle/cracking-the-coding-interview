package cracking.ch02.four;

import cracking.ch04.Node;

/**
 * getPivotLinkedList
 *
 * @author jongUn
 * @since 2018. 07. 15.
 */
public class getPivotLinkedList {
	public Node split(Node node, int standard) {
		if(node == null) {
			return null;
		}

		Node head = node;
		Node tail = node;
		Node current = node;

		while(current != null) {
			if(current.value < standard) {
				current.next = head;
				head = current;
			} else {
				tail.next = current;
				tail = current;
			}
			current = current.next;
		}
		tail.next = null;

		return head;
	}

}
