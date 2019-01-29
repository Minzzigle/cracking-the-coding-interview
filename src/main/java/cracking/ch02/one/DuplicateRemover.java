package cracking.ch02.one;

import cracking.ch02.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * DuplicateRemover
 *
 * @author jongUn
 * @since 2019. 01. 29.
 */
public class DuplicateRemover {

	/**
	 * 추가 공간을 사용하는 경우
	 * @param root
	 */
	public void remove(Node root) {

		if(root == null) {
			return;
		}

		Map<Integer, Boolean> map = new HashMap<>();

		map.put(root.data, true);

		while(root.next != null) {

			if(map.containsKey(root.next.data)) {
				root.next = root.next.next;
			}

			if(root.next != null) {
				root = root.next;
				map.put(root.data, true);
			}
		}
	}

	/**
	 * 추가 공간을 사용하지 않는 경우
	 * @param root
	 */
	public void removeWithoutSpace(Node root) {

		if(root == null) {
			return;
		}

		Node current = root;
		Node runner = root;

		while(current != null) {
			while(runner.next != null) {

				if(current.data == runner.next.data) {
					runner.next = runner.next.next;
				}

				if(runner.next != null) {
					runner = runner.next;
				}
			}

			current = current.next;
			runner = current;
		}

	}
}
