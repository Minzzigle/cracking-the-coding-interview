package cracking.ch04.ten;

import cracking.ch04.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * CheckSubTree
 *
 * @author jongUn
 * @since 2017. 11. 09.
 */
public class CheckSubTree {
	public boolean check(Node head, Node subHead) {
		if(head == null) {
			return false;
		}

		Node[] children = head.children;

		boolean left = check(children[0], subHead);

		if(left == true) {
			return true;
		}

		boolean right = check(children[1], subHead);

		if(right == true) {
			return true;
		}

		List<Integer> inOrder = makeInOrder(head);

		// 외부 함수에서 한 번만 InOrder를 계산해서 이 함수에 흘려주면 이 연산을 재귀마다 수행할 필요가 없다
		// targetNode의 InOrder는 항상 동일하기 때문이다.
		List<Integer> targetInOrder = new ArrayList<>();
		getInOrder(subHead, targetInOrder);

		return isSame(inOrder, targetInOrder);
	}

	private List<Integer> makeInOrder(Node head) {
		List<Integer> leftInOrder = new ArrayList<>();
		getInOrder(head.children[0], leftInOrder);
		List<Integer> rightInOrder = new ArrayList<>();
		getInOrder(head.children[1], rightInOrder);
		leftInOrder.add(head.value);
		leftInOrder.addAll(rightInOrder);
		return leftInOrder;
	}

	private boolean isSame(List<Integer> leftInOrder, List<Integer> subTree) {
		if(leftInOrder.size() != subTree.size()) {
			return false;
		}

		for(int i = 0; i<leftInOrder.size(); i++) {
			if(leftInOrder.get(i) != subTree.get(i)) {
				return false;
			}
		}

		return true;
	}

	private void getInOrder(Node child, List<Integer> result) {
		if(child == null) {
			return;
		}

		getInOrder(child.children[0], result);
		result.add(child.value);
		getInOrder(child.children[1], result);
	}
}
