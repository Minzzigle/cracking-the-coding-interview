package cracking.ch04.eight;

import cracking.ch04.TreeNode;

public class SameAncestorFinder {

    public TreeNode findOnHasParentPath(TreeNode head, TreeNode firstNode, TreeNode secondNode) {
        if(head == null) {
            return null;
        }
        TreeNodeDepth treeNodeDepth = findComparedDepth(firstNode, secondNode);

        for(int i =0; i<treeNodeDepth.count; i++) {
            if(treeNodeDepth.node == firstNode) {
                firstNode = firstNode.parent;
            }

            if(treeNodeDepth.node == secondNode) {
                secondNode = secondNode.parent;
            }
        }

        while(firstNode != null && secondNode != null && firstNode != secondNode) {
            firstNode =firstNode.parent;
            secondNode = secondNode.parent;
        }

    return firstNode;
    }

    private TreeNodeDepth findComparedDepth(TreeNode firstNode, TreeNode secondNode) {
        // head node 까지의 거리를 젠다
        TreeNode first = firstNode;
        TreeNode second = secondNode;

        while(first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        int count= 0;
        while(first != null) {
            count++;
            first = first.parent;
            return new TreeNodeDepth(firstNode, count);
        }
        while (second != null) {
            count++;
            second = second.parent;
            return new TreeNodeDepth(secondNode, count);
        }

        return null;
    }

    /**
     * 부모로 타고 올라가면서 자신의 형제에 두번째 노드가 속해있는지 확인한다.
     * 속해있다면 해당 노드의 부모를 리턴한다.
	 * O(n)
     * @param head
     * @param firstNode
     * @param secondNode
     * @return
     */
    public TreeNode findOnHasParentPath2(TreeNode head, TreeNode firstNode, TreeNode secondNode) {
        if(head == null) {
            return null;
        }

        if(cover(firstNode, secondNode)) {
            return firstNode;
        }

        if(cover(secondNode, firstNode)) {
            return secondNode;
        }


        while(firstNode != null) {
            TreeNode sibling = getSibling(firstNode);

            if(cover(sibling, secondNode)) {
                return firstNode.parent;
            }

            firstNode = firstNode.parent;
        }

        return null;
    }

    private TreeNode getSibling(TreeNode firstNode) {
        if(firstNode == null) {
            return null;
        }

        if(firstNode.parent.leftChild == firstNode) {
            return firstNode.parent.rightChild;
        }

        if(firstNode.parent.rightChild == firstNode) {
            return firstNode.parent.rightChild;
        }

        return null;
    }

    // 해당 트리에 노드가 포함되어 있는지 확인한다.
    private boolean cover(TreeNode root, TreeNode node) {

    	if(root == null) {
    	    return false;
        }

        if(root == node) {
    	    return true;
        }

        return cover(root.leftChild, node) || cover(root.rightChild, node);
    }

    /**
     * 부모와의 연결이 없는 경우 문제 해결 방법
	 * O(n)
     */
    public TreeNode find(TreeNode head, TreeNode firstNode, TreeNode secondNode) {
        if(head == null) {
            return null;
        }

        boolean hasFirstNode = cover(head.leftChild, firstNode);
		boolean hasSecondNode = cover(head.leftChild, secondNode);

		// 왼쪽에 다 있는게 아님
		if(hasFirstNode != hasSecondNode) {
		    return head;
        }

        if(hasFirstNode) {
		    return find(head.leftChild, firstNode, secondNode);
		} else {
            return find(head.rightChild, firstNode, secondNode);
        }
    }

    class TreeNodeDepth {
        TreeNode node;
        int count;

        public TreeNodeDepth(TreeNode node, int count) {
            this.node = node;
            this.count = count;
        }
    }
}

