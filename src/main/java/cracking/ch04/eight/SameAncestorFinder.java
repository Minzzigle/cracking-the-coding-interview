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

    public TreeNode find(TreeNode head, TreeNode firstNode, TreeNode secondNode) {
        return null;
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

