package cracking.ch04.three;

import cracking.ch04.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NodeConnectTest {
    private NodeConnect nodeConnect = new NodeConnect();
    private Node head = null;

    @Before
    public void before() {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");

        node1.children = new Node[]{node2, node3};
        node2.children = new Node[]{node4, node5};
        node3.children = new Node[]{node6, node7};

        head = node1;
    }

    @Test
    public void connect() throws Exception {
        // given

        // when
        List<Node> result = nodeConnect.connect(head);

        // then
        assertThat(result.get(0), is(head));
        assertThat(result.get(1), is(head.children[0]));
        assertThat(result.get(2), is(head.children[0].children[0]));
    }

}