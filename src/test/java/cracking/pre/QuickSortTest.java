package cracking.pre;

import org.junit.Before;
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

	private QuickSort quickSort;

	@Before
	public void before() {
		quickSort = new QuickSort();
	}

	@Test
	public void sort() {
		// given
		int [] arr = {2, 3, 1};

		// when
		quickSort.sort(arr, 0, 2);

		// then
		int [] expected = {1, 2, 3};
		assertThat(arr, is(expected));
	}

	@Test
	public void sort_빈배열이들어오는경우() {
		// given
		int[] arr = {};

		// when
		quickSort.sort(arr, 0, 0);

		// then
		assertThat(arr, is(arr));
	}
}