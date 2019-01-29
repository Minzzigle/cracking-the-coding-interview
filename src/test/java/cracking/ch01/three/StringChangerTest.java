package cracking.ch01.three;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * StringChangerTest
 *
 * @author jongUn
 * @since 2019. 01. 29.
 */
public class StringChangerTest {

	private StringChanger stringChanger;

	@Before
	public void setUp() {
		stringChanger = new StringChanger();
	}

	@Test
	public void changeBlank_빈칸인경우() {
		// given
		char [] input = new char[0];

		// when
		stringChanger.changeBlank(input, 0);

		// then
		assertThat(input, is(input));
	}

	@Test
	public void changeBlank_입력값이존재하는경우() {
		// given
		char [] input = new char[17];
		input[0] = 'M';
		input[1] = 'r';
		input[2] = ' ';
		input[3] = 'J';
		input[4] = 'o';
		input[5] = 'h';
		input[6] = 'n';
		input[7] = ' ';
		input[8] = 'S';
		input[9] = 'm';
		input[10] = 'i';
		input[11]= 't';
		input[12]= 'h';

		// when
		stringChanger.changeBlank(input, 13);

		// then
		assertThat(String.valueOf(input), is("Mr%20John%20Smith"));
	}
}