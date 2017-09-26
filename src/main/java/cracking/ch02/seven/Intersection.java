package cracking.ch02.seven;

import cracking.ch02.LinkedList;
import cracking.ch02.Node;
import sun.awt.image.ImageWatched;

public class Intersection {
    /**
     * O(n^2)
     * @param l1
     * @param l2
     * @return
     */
    public Node solve1(LinkedList l1, LinkedList l2) {
        Node node1 = l1.head;
        while(node1 != null) {
            Node node2 = l2.head;
            while(node2 != null) {
                if(node2 == node1) {
                    return node2;
                }
                node2 = node2.next;
            }
            node1 = node1.next;
        }

        return null;
    }
}
