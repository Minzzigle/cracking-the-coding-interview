package cracking.ch04.one;

import cracking.ch04.Graph;
import cracking.ch04.Node;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FindPathTest {

    private FindPath findPath;

    @Before
    public void setUp() {
        findPath = new FindPath();
    }

    @Test
    public void solve() {
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
        boolean result = findPath.solve(g, a, e);
        boolean result2 = findPath.solve(g, a, f);

        // then
        assertThat(result, is(true));
        assertThat(result2, is(false));
    }

    @Test
    public void solve_그래프가하나도없는경우() {
        // given
        Graph graph = new Graph(null);

        // when
		boolean result = findPath.solve(graph, new Node("a"), new Node("b"));

        // then
		assertThat(result, is(false));
    }

    @Test
    public void solve_그래프안에두노드가없는경우() {
        // given
		Graph graph = new Graph(new Node("a"), new Node("b"));

        // when
		boolean result = findPath.solve(graph, new Node("z"), new Node("b"));

        // then
		assertThat(result, is(false));
    }
}