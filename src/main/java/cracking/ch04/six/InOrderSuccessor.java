package cracking.ch04.six;

import cracking.ch04.TreeNode;

/**
 * InOrderSuccessor
 * 이진탐색트리에서 주어진 노드의 in-order-successor를 찾는다.
 * inOrderSuccessor란, 트리를 in order search 시에 다음으로 탐색할 노드를 의미한다.
 *
 * @author jongUn
 * @since 2017. 11. 12.
 */
public class InOrderSuccessor {
	public TreeNode find(TreeNode inputNode) {
		if(inputNode == null) {
			return null;
		}

		// right child가 null인 경우에는, 해당 부분트리는 모두 탐색된 것이다.
		// 부모를 거슬러 올라가서, 부모의 값이 커지는 경우를 리턴한다.
		if(inputNode.rightChild == null) {
			int inputNodeData = inputNode.data;
			TreeNode parent = inputNode.parent;
			while(parent.data <= inputNodeData) {
				parent = inputNode.parent;
			}
			return parent;
		}

		TreeNode node = inputNode.rightChild;
		while(node.leftChild != null) {
			node = node.leftChild;
		}

		return node;
	}
}
