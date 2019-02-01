package cracking.ch08.one;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * StepTest
 *
 * @author jongUn
 * @since 2018. 01. 10.
 */
public class StepTest {
	private Step step = new Step(40);

	@Test
	public void step() {
		// given

		// when
		int result = step.step(3);

		// then
		assertThat(result, is(4));
	}

}