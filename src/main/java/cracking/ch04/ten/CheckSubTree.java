package cracking.ch04.ten;

import cracking.ch04.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * CheckSubTree
 *
 * @author jongUn
 * @since 2017. 11. 09.
 */
public class CheckSubTree {
	public boolean check(TreeNode head, TreeNode subHead) {
		if(head == null) {
			return false;
		}

		boolean left = check(head.leftChild, subHead);

		if(left == true) {
			return true;
		}

		boolean right = check(head.rightChild, subHead);

		if(right == true) {
			return true;
		}

		List<Integer> preOrder = makePreOrder(head);

		// 외부 함수에서 한 번만 preOrder 계산해서 이 함수에 흘려주면 이 연산을 재귀마다 수행할 필요가 없다
		// targetNode의 preOrder는 항상 동일하기 때문이다.
		List<Integer> targetInOrder = new ArrayList<>();
		getPreOrder(subHead, targetInOrder);

		return isSame(preOrder, targetInOrder);
	}

	private List<Integer> makePreOrder(TreeNode head) {
		List<Integer> leftPreOrder = new ArrayList<>();
		leftPreOrder.add(head.data);
		getPreOrder(head.leftChild, leftPreOrder);
		List<Integer> rightInOrder = new ArrayList<>();
		getPreOrder(head.rightChild, rightInOrder);
		leftPreOrder.addAll(rightInOrder);
		return leftPreOrder;
	}

	private boolean isSame(List<Integer> preOrder, List<Integer> subTree) {
		if(preOrder.size() != subTree.size()) {
			return false;
		}

		for(int i = 0; i<preOrder.size(); i++) {
			if((int)preOrder.get(i) != (int)(subTree.get(i))) {
				return false;
			}
		}

		return true;
	}

	private void getPreOrder(TreeNode child, List<Integer> result) {
		if(child == null) {
			result.add(Integer.MIN_VALUE);
			return;
		}

		result.add(child.data);
		getPreOrder(child.leftChild, result);
		getPreOrder(child.rightChild, result);
	}
}
