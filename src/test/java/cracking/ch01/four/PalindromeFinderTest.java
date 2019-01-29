package cracking.ch01.four;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * PalindromeFinderTest
 *
 * @author jongUn
 * @since 2019. 01. 29.
 */
public class PalindromeFinderTest {

	private PalindromeFinder palindromeFinder;

	@Before
	public void setUp() {
		palindromeFinder = new PalindromeFinder();
	}

	@Test
	public void find_공백입력됨() {
		// given

		// when
		boolean result = palindromeFinder.find("");

		// then
		assertThat(result, is(true));
	}

	@Test
	public void find_회문이아닌경우() {
		// given

		// when
		boolean result = palindromeFinder.find("tafp att");

		// then
		assertThat(result, is(false));
	}

	@Test
	public void find_회문인경우() {
		// given

		// when
		boolean result = palindromeFinder.find("tact coa");

		// then
		assertThat(result, is(true));
	}
}