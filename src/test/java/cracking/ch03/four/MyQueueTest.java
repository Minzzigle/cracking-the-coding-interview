package cracking.ch03.four;

import cracking.ch03.Queue;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * MyQueueTest
 *
 * @author jongUn
 * @since 2017. 09. 29.
 */
public class MyQueueTest {
	private MyQueue<Integer> myQueue = new MyQueue<>();

	@Before
	public void before() {
		for(int i = 0; i<10; i++) {
			myQueue.add(i);
		}
	}

	@Test
	public void remove() throws Exception {
		// given

		// when
		Integer result = myQueue.remove();
		Integer result2 = myQueue.remove();

		// then
		assertThat(result, is(0));
		assertThat(result2, is(1));
	}

	@Test
	public void peek() throws Exception {
		// given

		// when
		Integer result = myQueue.peek();
		Integer result2 = myQueue.peek();

		// then
		assertThat(result, is(0));
		assertThat(result2, is(0));

	}

	@Test
	public void isEmpty() throws Exception {
		// given

		// when
		boolean result = myQueue.isEmpty();
		Queue<Integer> q = new Queue<>();
		boolean result2 = q.isEmpty();

		// then
		assertThat(result, is(false));
		assertThat(result2, is(true));

	}
}