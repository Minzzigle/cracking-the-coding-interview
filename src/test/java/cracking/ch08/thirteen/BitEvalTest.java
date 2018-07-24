package cracking.ch08.thirteen;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * BitEvalTest
 *
 * @author jongUn
 * @since 2018. 03. 17.
 */
public class BitEvalTest {
	private BitEval bitEval = new BitEval();

	@Test
	public void countEval() throws Exception {
		// given
		String input = "1^0|0|1";
		boolean resultEval = false;

		// when
		int result = bitEval.countEval(input, resultEval);

		// then
		assertThat(result, is(2));
	}

}