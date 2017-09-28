package cracking.ch03;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * StackTest
 *
 * @author jongUn
 * @since 2017. 09. 28.
 */
public class StackTest {
	private Stack<Integer> stack = new Stack<>();

	@Before
	public void before() {
		for(int i = 0; i<10; i++) {
			stack.push(i);
		}
	}


	@Test
	public void pop() throws Exception {
		// given

		// when
		Integer result = stack.pop();

		// then
		assertThat(result, is(9));

	}

	@Test
	public void peek() throws Exception {
		// given

		// when
		Integer result = stack.peek();
		Integer top = stack.pop();

		// then
		assertThat(result, is(9));
		assertThat(top, is(9));


	}

	@Test
	public void isEmpty() throws Exception {
		// given
		Stack<String> stack2 = new Stack<>();

		// when
		boolean result = stack.isEmpty();
		boolean result2 = stack2.isEmpty();

		// then
		assertThat(result, is(false));
		assertThat(result2, is(true));
	}

}