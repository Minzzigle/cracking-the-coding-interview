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

	@Test
	public void findBigStringWithoutSync() throws Exception {
		// given
		String input = "11223344556677889900--";
		Thread thread1 = new Thread(() -> {
			flyWeightService.findBigStringWithoutSync(input).getBigChars();
		});
		Thread thread2 = new Thread(() -> {
			flyWeightService.findBigStringWithoutSync(input).getBigChars();
		});
		Thread thread3 = new Thread(() -> {
			flyWeightService.findBigStringWithoutSync(input).getBigChars();
		});
		Thread thread4 = new Thread(() -> {
			flyWeightService.findBigStringWithoutSync(input).getBigChars();
		});
		Thread thread5 = new Thread(() -> {
			flyWeightService.findBigStringWithoutSync(input).getBigChars();
		});
		Thread thread6 = new Thread(() -> {
			flyWeightService.findBigStringWithoutSync(input).getBigChars();
		});
		Thread thread7 = new Thread(() -> {
			flyWeightService.findBigStringWithoutSync(input).getBigChars();
		});
		Thread thread8 = new Thread(() -> {
			flyWeightService.findBigStringWithoutSync(input).getBigChars();
		});
		Thread thread9 = new Thread(() -> {
			flyWeightService.findBigStringWithoutSync(input).getBigChars();
		});
		Thread thread10 = new Thread(() -> {
			flyWeightService.findBigStringWithoutSync(input).getBigChars();
		});

		// when
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		thread9.start();
		thread10.start();

		// then
	}
}