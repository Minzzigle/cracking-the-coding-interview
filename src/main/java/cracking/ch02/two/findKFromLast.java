package cracking.ch02.two;

import cracking.ch04.Node;

/**
 * findKFromLast
 *
 * @author jongUn
 * @since 2018. 07. 15.
 */
public class findKFromLast {
	public int getKUsingRec(Node node, int k) {
		if(node.next == null) {
			return 1;
		}

		int nextNodePos = getKUsingRec(node.next, k);

		if(nextNodePos + 1 == k) {
			System.out.println(node.value);
		}

		return nextNodePos + 1;
	}

	public Integer getKUsingRunner(Node node, int k) {
		if(node == null) {
			return null;
		}

		Node runner = node;

		for(int i = 0; i<k; i++) {
			runner = runner.next;
		}

		while(runner.next != null) {
			runner = runner.next;
			node = node.next;
		}

		return node.value;
	}


}
