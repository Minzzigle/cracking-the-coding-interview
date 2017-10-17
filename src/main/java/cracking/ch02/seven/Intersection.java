package cracking.ch02.seven;

import cracking.ch02.LinkedList;
import cracking.ch02.Node;

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

    /**
     * Node를 방문하는 visited나, Map에 hashcode를 저장하는 방법을 사용하지 않는 solution.
     * 정석적인 방법이다.
     * @param l1
     * @param l2
     * @return
     */
    public Node solve3(LinkedList l1, LinkedList l2) {
        if(l1 == null || l2 == null) {
            return null;
        }

        int length1 = getLength(l1);
        int length2 = getLength(l2);

        Node n1 = null;
        Node n2 = null;

        if(length1 > length2) {
            n1 = movePointer(l1, length1, length2);
            n2 = l2.head;
        } else if(length1 == length2){
            n1 = l1.head;
            n2 = l2.head;
        } else {
            n1 = l1.head;
            n2 = movePointer(l2, length2, length1);
        }

        while(n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;

    }

    private Node movePointer(LinkedList l1, int longer, int shorter) {
        Node node = l1.head;
        while(longer > shorter) {
            node = node.next;
            longer--;
        }

        return node;
    }

    private int getLength(LinkedList l1) {
        int length = 0;
        Node n = l1.head;
        while(n != null) {
            n = n.next;
            length++;
        }

        return length;
    }
}
