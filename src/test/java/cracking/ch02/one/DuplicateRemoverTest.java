package cracking.ch02.one;

import cracking.ch02.Node;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * DuplicateRemoverTest
 *
 * @author jongUn
 * @since 2019. 01. 29.
 */
public class DuplicateRemoverTest {

	private DuplicateRemover duplicateRemover;

	@Before
	public void setUp() {
		duplicateRemover = new DuplicateRemover();
	}

	@Test
	public void remove() {
		// given
		Node node = new Node(3);
		Node node2 = new Node(4);
		Node node3 = new Node(3);
		Node node4 = new Node(5);
		Node node5 = new Node(4);

		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		// when
		duplicateRemover.remove(node);

		// then
		assertThat(node.data, is(3));
		assertThat(node.next.data, is(4));
		assertThat(node.next.next.data, is(5));
	}

	@Test
	public void removeWithoutSpace() {
		// given
		Node node = new Node(3);
		Node node2 = new Node(4);
		Node node3 = new Node(3);
		Node node4 = new Node(5);
		Node node5 = new Node(4);

		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		// when
		duplicateRemover.removeWithoutSpace(node);

		// then
		assertThat(node.data, is(3));
		assertThat(node.next.data, is(4));
		assertThat(node.next.next.data, is(5));
	}
}
