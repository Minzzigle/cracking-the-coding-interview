package cracking.ch04.three;

import cracking.ch04.Node;

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

        while(!queue.isEmpty()) {
            Node n = queue.remove();
        }

        return Collections.EMPTY_LIST;
    }
}
