package cracking.ch08.three;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * MagicIndexTest
 *
 * @author jongUn
 * @since 2018. 01. 10.
 */
public class MagicIndexTest {
	private MagicIndex magicIndex = new MagicIndex();

	@Test
	public void find() {
		// given
		int [] arr = {-1,0,1,2,4,7};

		// when
		int result = magicIndex.find(arr, 0, 5);

		// then
		assertThat(result, is(4));
	}

	@Test
	public void find_대상이_없음() {
		// given
		int [] arr = {-1,0,1,2,3,7};

		// when
		int result = magicIndex.find(arr, 0, 5);

		// then
		assertThat(result, is(Integer.MIN_VALUE));
	}

}