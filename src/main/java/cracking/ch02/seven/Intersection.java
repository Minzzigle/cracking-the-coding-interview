package cracking.ch02.seven;

import cracking.ch02.LinkedList;
import cracking.ch02.Node;
import sun.awt.image.ImageWatched;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

	/**
     * O(m^2)
     * 위의 것보다 시간복잡도가 빠르다고 보기 어려울 수 있음
     * @param l1
     * @param l2
     * @return
     */
    public Node solve2(LinkedList l1, LinkedList l2) {
        Map<String, Integer> map = new HashMap<>();
        Node node1 = l1.head;

        while(node1 != null) {
            map.put(node1.toString(), 1);
            node1 = node1.next;
        }

        Node node2 = l2.head;

        while(node2 != null) {
            if(map.containsKey(node2.toString())) {
                return node2;
            }
            node2 = node2.next;
        }

        return null;
    }
}
