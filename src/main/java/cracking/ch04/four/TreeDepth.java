package cracking.ch04.four;

import cracking.ch04.Node;

/**
 * TreeDepth
 *
 * @author jongUn
 * @since 2017. 10. 20.
 */
public class TreeDepth {
	public boolean checkBalanced(Node node) {
		int depth = findDepth(node);

		if(depth == -1) {
			return false;
		}

		return true;
	}

	private int findDepth(Node node) {
		if(node == null) {
			return 0;
		}

		int leftDepth = findDepth(node.children[0]);
		int rightDepth = findDepth(node.children[1]);

		if(leftDepth == -1 || rightDepth == -1) {
			return -1;
		}

		if(Math.abs(leftDepth - rightDepth) > 1) {
			return -1;
		}

		if(leftDepth > rightDepth) {
			return leftDepth + 1;
		} else {
			return rightDepth + 1;
		}
	}

	public boolean isBalancedTree(Node root) {
		if(root == null) {
			return false;
		}

		int depth = getDepth(root);

		if(depth == -1) {
			return false;
		}

		return true;
	}


	public int getDepth(Node root) {
		if(root == null) {
			return 0;
		}

		int leftDepth = findDepth(root.children[0]);
		int rightDepth = findDepth(root.children[1]);

		if(leftDepth == -1 || rightDepth == -1) {
			return -1;
		}

		int abs = Math.abs(leftDepth - rightDepth);

		if(abs > 1) {
			return -1;
		}

		return leftDepth > rightDepth ? leftDepth : rightDepth;
	}

}
