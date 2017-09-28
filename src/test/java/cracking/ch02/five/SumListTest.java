package cracking.ch02.five;

import cracking.ch02.LinkedList;
import cracking.ch02.Node;
import cracking.ch02.five.SumList;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * SumListTest
 *
 * @author jongUn
 * @since 2017. 09. 22.
 */
public class SumListTest {
	@Test
	public void solve1() throws Exception {
		// given
		LinkedList list1 = new LinkedList(new Node(7));
		list1.appendToTail(1);
		list1.appendToTail(6);

		LinkedList list2 = new LinkedList(new Node(5));
		list2.appendToTail(9);
		list2.appendToTail(2);


		// when
		SumList sumList = new SumList();
		LinkedList result = sumList.solve(list1, list2);

		// then
		assertThat(result.print(), is("912"));
	}

}