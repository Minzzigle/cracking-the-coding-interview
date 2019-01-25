package cracking.ch04.one;

import cracking.ch04.*;

import java.util.LinkedList;

public class FindPath {
    public boolean solve(Graph g, Node start, Node end) {
        if(g == null || start == null || end == null) {
            return false;
        }

        if(g.nodes == null || g.nodes.length < 2) {
            return false;
        }

        initializeGraph(g);

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Node n = queue.remove();
            if(n == end) {
                return true;
            }
            n.visited = VisitedType.VISITED;
            for(Node child : n.children) {
                if(child.visited != VisitedType.VISITED) {
                    queue.add(child);
                }
            }
        }

        return false;
    }

    private void initializeGraph(Graph g) {
        for(Node n : g.nodes) {
            n.visited = VisitedType.UNDEFINED;
        }
    }
}
