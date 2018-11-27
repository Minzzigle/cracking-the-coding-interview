package cracking.ch02.seven;

import cracking.ch02.LinkedList;
import cracking.ch02.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 단방향 연결리스트 두 개가 주어졌을 때 이 두 리스트의 교집합 노드를 찾은 뒤 반환하는 코드를 작성하라. 여기서 교집합이란 노드의 값이 아니라 노드의 주소가 완전히 같은 경우를 말한다.
 * 즉, 첫 번째 리스트에 있는 k 번째 노드와 두 번째 리스트에 있는 j번째 노드가 주소까지 완전히 같다면 이 노드는 교집합의 원소가 된다.
 */
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
