package cracking.ch02.eight;

import cracking.ch02.LinkedList;
import cracking.ch02.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * FindLoop
 *
 * @author jongUn
 * @since 2017. 09. 28.
 */
public class FindLoop {
	public Node solve(LinkedList l1) {
		Map<String, Integer> map = new HashMap<>();
		Node node = l1.head;

		while(node != null) {
			if(map.containsKey(node.toString())) {
				return node;
			}
			map.put(node.toString(), 1);
			node = node.next;
		}

		return null;
	}
}
