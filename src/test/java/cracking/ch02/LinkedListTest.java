package cracking.ch02;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * LinkedListTest
 *
 * @author jongUn
 * @since 2017. 09. 22.
 */
public class LinkedListTest {
	private LinkedList list;

	@Before
	public void before() {
		list = new LinkedList(new Node(1));
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(5);
	}

	@Test
	public void appendToTail() throws Exception {
		// given

		// when
		String result = list.print();

		// then
		assertThat(result, is("12345"));

	}

	@Test
	public void deleteNode() throws Exception {
		// given

		// when
		list.deleteNode(3);

		// then
		assertThat(list.print(), is("1 2 4 5 "));

	}

}