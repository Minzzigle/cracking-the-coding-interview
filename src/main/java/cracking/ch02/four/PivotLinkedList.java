package cracking.ch02.four;

import cracking.ch02.Node;

/**
 * 값 x가 주어졌을 때, x 보다 작은 노드들을 x보다 크거나 같은 노드보다 앞에 오도록 하는 코드를 작성하라. 만약 x 가 리스트에 있다면 x는 그보다 작은 원소들보다 뒤에 나오기만 하면 된다.
 * 즉, 원소 x 는 '오른쪽 그룹' 어딘가에만 존재하면 된다. 왼쪽과 오른쪽 그룹 사이에 있을 필요는 없다.
 *
 * 입력 : 3 > 5 > 8 > 5 > 10 > 2 > 1 [분할값 x = 5]
 * 출력 : 3 > 1 > 2 > 10 > 5 > 5 > 8
 *
 * @author jongUn
 * @since 2018. 07. 15.
 */
public class PivotLinkedList {

	/**
	 * 포인터를 4개 유지하여, LinkedList 를 순회하며 standard 보다 작은 값과 큰 값으로 리스트를 분리 후 머지한다.
	 * 해당 방법으로 수행하였을 때 결과값은 stable 하다.
	 * @param node
	 * @param standard
	 * @return
	 */
	public Node split(Node node, int standard) {
		if (node == null) {
			return null;
		}

		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;

		while (node != null) {

			if (node.data < standard) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = node;
				} else {
					beforeEnd.next = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = node;
				} else {
					afterEnd.next = node;
				}
			}

			node = node.next;
		}

		beforeEnd.next = null;
		afterEnd.next = null;

		beforeEnd.next = afterStart;

		return beforeStart;
	}

	/**
	 * 하나의 배열에서 had 와 tail 에 원소들을 붙여 나가면서 리스트를 생성한다.
	 * 결과값이 stable 하지 않다.
	 * @param node
	 * @param standard
	 * @return
	 */
	public Node splitByOneList(Node node, int standard) {
		if(node == null) {
			return null;
		}

		Node head = node;
		Node tail = node;

		while(node != null) {
			Node next = node.next;

			if(node.data < standard) {
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}

			node = next;
		}
		tail.next = null;

		return head;
	}
}
