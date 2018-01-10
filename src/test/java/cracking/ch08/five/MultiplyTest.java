package cracking.ch08.five;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * MultiplyTest
 *
 * @author jongUn
 * @since 2018. 01. 10.
 */
public class MultiplyTest {
	private Multiply multiply = new Multiply();

	@Test
	public void multiply() throws Exception {
		// given

		// when
		int result = multiply.multiply(5, 7);

		// then
		assertThat(result, is(35));
	}

	@Test
	public void multiply2() throws Exception {
		// given

		// when
		int result = multiply.multiply(5, 9);

		// then
		assertThat(result, is(45));
	}

}