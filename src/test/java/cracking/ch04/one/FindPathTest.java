package cracking.ch04.one;

import cracking.ch04.Graph;
import cracking.ch04.Node;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FindPathTest {
    @Test
    public void solve() throws Exception {
        // given
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.children = new Node[]{b};
        b.children = new Node[]{c};
        c.children = new Node[]{d};
        d.children = new Node[]{e};

        Graph g = new Graph(a,b,c,d,e);

        // when
        FindPath findPath = new FindPath();
        boolean result = findPath.solve(g, a, e);
        boolean result2 = findPath.solve(g, a, f);

        // then
        assertThat(result, is(true));
        assertThat(result2, is(false));
    }

}