package cracking.pre;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * QuickSortTest
 *
 * @author jongUn
 * @since 2018. 07. 20.
 */
public class QuickSortTest {

	private QuickSort quickSort = new QuickSort();

	@Test
	public void sort() throws Exception {
		// given
		int [] arr = {2, 3, 1};

		// when
		quickSort.sort(arr, 0, 2);

		// then
		int [] expected = {1, 2, 3};
		assertThat(arr, is(expected));
	}
}