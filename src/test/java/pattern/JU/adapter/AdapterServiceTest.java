package pattern.JU.adapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pattern.Application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by cha45 on 2017-04-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AdapterServiceTest {
    private static String WEAK_STRING = "(input)";
    private static String STRONG_STRING = "*input*";

    @Autowired
    private AdapterService adapterService;

    @Test
    public void printWeakWithInheritance() throws Exception {
        // given

        // when
        String result = adapterService.printWeakWithInheritance();

        // then
        assertThat(result, is(WEAK_STRING));
    }

    @Test
    public void printStrongWithInheritance() throws Exception {
        // given

        // when
        String result = adapterService.printStrongWithInheritance();

        // then
        assertThat(result, is(STRONG_STRING));
    }

    @Test
    public void printWeakWithDelegate() throws Exception {
        // given

        // when
        String result = adapterService.printWeakWithDelegate();

        // then
        assertThat(result, is(WEAK_STRING));
    }

    @Test
    public void printStrongWithDelegate() throws Exception {
        // given

        // when
        String result = adapterService.printStrongWithDelgate();

        // then
        assertThat(result, is(STRONG_STRING));
    }

}