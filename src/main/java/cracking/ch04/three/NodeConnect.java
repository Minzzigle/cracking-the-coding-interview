package cracking.ch04.three;

import cracking.ch04.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NodeConnect {
    public List<List<Node>> connect(Node root) {
        List<List<Node>> result = new ArrayList<>();
        connect(root, result, 0);

        return result;
    }


    public void connect(Node root, List<List<Node>> nodeList, int level) {
        if(root == null) {
            return;
        }

        List<Node> linkedList;
        if(nodeList.size() == level) {
            linkedList = new LinkedList<>();
            nodeList.add(linkedList);
        } else {
            linkedList = nodeList.get(level);
        }

        linkedList.add(root);
        connect(root.children[0], nodeList, level + 1);
        connect(root.children[1], nodeList, level + 1);
    }
}
