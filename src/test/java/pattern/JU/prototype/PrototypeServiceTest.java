package pattern.JU.prototype;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pattern.Application;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * PrototypeServiceTest
 *
 * @author jongUn
 * @since 2017. 04. 26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class PrototypeServiceTest {
	private static final String TEST = "TEST";

	MessageBox starBox = new MessageBox("*");
	MessageBox underlineBox = new MessageBox("_");

	@Autowired
	private PrototypeService prototypeService;

	@Before
	public void before() {
		prototypeService.register("starBox", starBox);
		prototypeService.register("underlineBox", underlineBox);
	}

	@Test
	public void create_messageBox() {
		// given

		// when
		Product result = prototypeService.create("starBox");

		// then
		assertThat(result.use(TEST), is("*TEST*"));
		assertThat(result.getClass().toString(), is(starBox.getClass().toString()));
		assertThat(result.hashCode(), not(starBox.hashCode()));
	}

	@Test
	public void create_underLineBox() {
		// given

		// when
		Product result = prototypeService.create("underlineBox");

		// then
		assertThat(result.use(TEST), is("_TEST_"));
		assertThat(result.getClass().toString(), is(underlineBox.getClass().toString()));
		assertThat(result.hashCode(), not(underlineBox.hashCode()));
	}
}