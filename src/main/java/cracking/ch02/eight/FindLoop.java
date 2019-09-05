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

	/**
	 * 1. fastStarter(이하 f)와 slowStarter(이하 s)를 정의한다.
	 * 2. f는 두 칸, s는 한 칸씩 전진시킨다.
	 * 3. s가 f와 만나는 순간(이 지점을 c라 한다.), head부터 새로운 포인터를 출발시킨다.
	 * 4. 새로운 포인터와, c를 한칸씩 전진시켜 두 포인터가 만나는 지점이 루프의 시작지점이다.
	 * @param l1
	 * @return
	 */
	public Node solve2(LinkedList l1) {
		Node fastStarter = l1.head;
		Node slowStarter = l1.head;
		Node collision = getCollision(fastStarter, slowStarter);

		Node startNode = l1.head;

		while(startNode != collision) {
			startNode = startNode.next;
			collision = collision.next;
		}

		return startNode;
	}

	private Node getCollision(Node fastStarter, Node slowStarter) {
		while(fastStarter != slowStarter) {
			fastStarter = fastStarter.next.next;
			slowStarter = slowStarter.next;
		}

		return fastStarter;
	}
}
