package cracking.ch04;

public class Node {
    public String name;
    public Node[] children = new Node[]{};
    public VisitedType visited;

    public Node(String name) {
        this.name = name;
    }
}
