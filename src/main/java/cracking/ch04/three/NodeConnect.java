package cracking.ch04.three;

import cracking.ch04.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NodeConnect {
    public List<Node> connect(Node head) {
        if(head == null) {
            return Collections.EMPTY_LIST;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);

        List<Node> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            Node n = toLinkedList(queue);
            result.add(n);

            Node listHead = n;

            while(listHead != null) {
                for(int i = 0; i<listHead.children.length; i++) {
                    queue.add(listHead.children[i]);
                }
                listHead = listHead.next;
            }
        }

        return result;
    }

    private Node toLinkedList(LinkedList<Node> queue) {
        Node head = queue.peekFirst();
        Node pre = null;
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if(pre != null) {
                pre.next= node;
            }
            pre = node;
        }

        return head;
    }
}
