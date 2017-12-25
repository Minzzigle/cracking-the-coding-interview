package cracking.ch01.one;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * SameLetterTest
 *
 * @author jongUn
 * @since 2017. 12. 22.
 */
public class SameLetterTest {
	public SameLetter sameLetter = new SameLetter();

	@Test
	public void hasSameLetter() {
		// given
		String input = "afhadab";

		// when
		boolean result = sameLetter.hasSameLetter(input);

		// then
		assertThat(result, is(true));
	}

	@Test
	public void notHasSameLetter() {
		// given
		String input = "abcde";

		// when
		boolean result = sameLetter.hasSameLetter(input);

		// then
		assertThat(result, is(false));

	}
}