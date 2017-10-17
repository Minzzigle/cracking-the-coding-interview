package cracking.ch04;

public class Node {
    public String name;
    public Node[] children = new Node[]{};
    public VisitedType visited;
    public Node next;

    public Node(String name) {
        this.name = name;
    }
}
