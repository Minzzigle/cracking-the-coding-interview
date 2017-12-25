package cracking.ch01.two;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * SameSentenceTest
 *
 * @author jongUn
 * @since 2017. 12. 25.
 */
public class SameSentenceTest {
	private String sameS1 = "qwerqwer";
	private String saneS2 = "qqwweerr";
	private String notSameS1 = "qwerqweraawafg";
	private String notSameS2 = "qqwweerrbbqbfg";

	private SameSentence sameSentence = new SameSentence();

	@Test
	public void sameSentenceBySort() {
		// given

		// when
		boolean result = sameSentence.isSameSentence(sameS1, saneS2);

		// then
		assertThat(result, is(true));
	}

	@Test
	public void notSameSentenceBySort() {
		// given

		// when
		boolean result = sameSentence.isSameSentence(notSameS1, notSameS2);

		// then
		assertThat(result, is(false));
	}

	@Test
	public void sameSentenceByMap() {

		// when
		boolean result = sameSentence.isSameSentenceByMap(sameS1, saneS2);

		// then
		assertThat(result, is(true));
	}

	@Test
	public void notSameSentenceByMap() {
		// given

		// when
		boolean result = sameSentence.isSameSentenceByMap(notSameS1, notSameS2);

		// then
		assertThat(result, is(false));
	}
}