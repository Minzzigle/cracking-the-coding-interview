package pattern.JU.flyweight;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pattern.Application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * FlyWeightServiceTest
 *
 * @author jongUn
 * @since 2017. 05. 07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class FlyWeightServiceTest {
	@Autowired
	private FlyWeightService flyWeightService;

	@Test
	public void findBigString() throws Exception {
		// given
		String input = "1234567890";

		// when
		BigChar[] result = flyWeightService.findBigString(input).getBigChars();

		// then
		assertThat(result.length, is(input.length()));
		for(int i = 0; i<result.length; i++) {
			assertThat(result[i].getCharName(), is(input.charAt(i)));
		}
	}


}