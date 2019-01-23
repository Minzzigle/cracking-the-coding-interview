package cracking.ch08.four;

import java.util.List;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * SubSetTest
 *
 * @author jongUn
 * @since 2018. 01. 10.
 */
public class SubSetTest {
	private SubSet subSet = new SubSet();

	@Test
	public void print() {
		// given

		// when
		List<String> result = subSet.print("abc");

		// then
		assertThat(result.contains("a"), is(true));
		assertThat(result.contains("b"), is(true));
		assertThat(result.contains("ab"), is(true));

	}

}