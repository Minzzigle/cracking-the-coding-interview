package cracking.ch02.eight;

import cracking.ch02.LinkedList;
import cracking.ch02.Node;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * FindLoopTest
 *
 * @author jongUn
 * @since 2017. 09. 28.
 */
public class FindLoopTest {
	@Test
	public void solve() throws Exception {
		// given
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		LinkedList l1 = new LinkedList();
		l1.appendToTailNode(node1);
		l1.appendToTailNode(node2);
		l1.appendToTailNode(node3);
		l1.appendToTailNode(node4);
		l1.appendToTailNode(node5);
		l1.appendToTailNode(node1);

		// when
		FindLoop findLoop = new FindLoop();
		Node result = findLoop.solve(l1);

		// then
		assertThat(result, is(node1));
	}

}