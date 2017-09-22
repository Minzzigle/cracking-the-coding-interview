package cracking.ch02;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * SumList_02_05Test
 *
 * @author jongUn
 * @since 2017. 09. 22.
 */
public class SumList_02_05Test {
	@Test
	public void solve() throws Exception {
		// given
		LinkedList list1 = new LinkedList(new Node(7));
		list1.appendToTail(1);
		list1.appendToTail(6);

		LinkedList list2 = new LinkedList(new Node(5));
		list2.appendToTail(9);
		list2.appendToTail(2);


		// when
		SumList_02_05 sumList_02_05 = new SumList_02_05();
		LinkedList result = sumList_02_05.solve(list1, list2);

		// then
		assertThat(result.printAll(), is("912"));
	}

}