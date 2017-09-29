package cracking.ch03.three;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * SetOfStacksTest
 *
 * @author jongUn
 * @since 2017. 09. 29.
 */
public class SetOfStacksTest {
	private SetOfStacks<Integer> setOfStacks = null;

	@Before
	public void before() {
		setOfStacks = new SetOfStacks<>();
		for(int i = 0; i<10; i++) {
			setOfStacks.push(i);
		}
	}

	@Test
	public void pop() throws Exception {
		// given

		// when
		Integer result = setOfStacks.pop();
		for(int i = 0; i<9; i++) {
			setOfStacks.pop();
		}
		boolean isEmpty = setOfStacks.isEmpty();

		// then
		assertThat(result, is(9));
		assertThat(isEmpty, is(true));
	}

	@Test
	public void peek() throws Exception {
		// given

		// when
		Integer result = setOfStacks.peek();

		// then
		assertThat(result, is(9));

	}

	@Test
	public void isEmpty() throws Exception {
		// given

		// when
		boolean result = setOfStacks.isEmpty();
		for(int i =0; i<10; i++) {
			setOfStacks.pop();
		}

		boolean result2 = setOfStacks.isEmpty();


		// then
		assertThat(result, is(false));
		assertThat(result2, is(true));
	}

	@Test
	public void popAt() {
		// given

		// when
		Integer result = setOfStacks.popAt(1);

		// then
		assertThat(result, is(7));
	}

}