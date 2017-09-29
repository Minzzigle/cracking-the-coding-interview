package cracking.ch03;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * QueueTest
 *
 * @author jongUn
 * @since 2017. 09. 29.
 */
public class QueueTest {
	private Queue<Integer> queue = new Queue<>();

	@Before
	public void before() {
		for(int i = 0; i<10; i++) {
			queue.add(i);
		}
	}

	@Test
	public void remove() throws Exception {
		// given

		// when
		Integer result = queue.remove();
		Integer result2 = queue.remove();

		// then
		assertThat(result, is(0));
		assertThat(result2, is(1));
	}

	@Test
	public void peek() throws Exception {
		// given

		// when
		Integer result = queue.peek();
		Integer result2 = queue.peek();

		// then
		assertThat(result, is(0));
		assertThat(result2, is(0));

	}

	@Test
	public void isEmpty() throws Exception {
		// given

		// when
		boolean result = queue.isEmpty();
		Queue<Integer> q = new Queue<>();
		boolean result2 = q.isEmpty();

		// then
		assertThat(result, is(false));
		assertThat(result2, is(true));

	}

}