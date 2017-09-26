package cracking.ch02;

/**
 * LinkedList
 *
 * @author jongUn
 * @since 2017. 09. 22.
 */
public class LinkedList {
	public Node head;

	public LinkedList(Node head) {
		this.head = head;
	}

	public LinkedList() {
	}

	public void appendToTailNode(Node end) {
		Node n = head;
		if(head == null) {
			head = end;
			return;
		}
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = head;
		if(head == null) {
			head = end;
			return;
		}
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void deleteNode(int d) {
		Node n = head;
		if(n.data == d) {
			head = head.next;
		}

		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
			}
			n = n.next;
		}
	}

	public String print() {
		Node n = head;
		String result = "";
		while(n != null) {
			result += n.data;
			n = n.next;
		}

		return result;
	}
}
