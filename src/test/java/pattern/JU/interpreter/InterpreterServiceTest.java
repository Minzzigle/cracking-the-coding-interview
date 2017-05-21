package pattern.JU.interpreter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pattern.Application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by cha45 on 2017-05-21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class InterpreterServiceTest {
    @Autowired
    private InterpreterService interpreterService;

    @Test
    public void parse1() throws Exception {
        // given
        String input = "program end";

        // when
        String result = interpreterService.parse(input);

        // then
        assertThat(result, is("[program []]"));
    }

    @Test
    public void parse2() throws Exception {
        // given
        String input = "program go end";

        // when
        String result = interpreterService.parse(input);

        // then
        assertThat(result, is("[program [go]]"));
    }

    @Test
    public void parse3() throws Exception {
        // given
        String input = "program go right go right go right go right end";

        // when
        String result = interpreterService.parse(input);

        // then
        assertThat(result, is("[program [go, right, go, right, go, right, go, right]]"));
    }

    @Test
    public void parse4() throws Exception {
        // given
        String input = "program repeat 4 go right end end";

        // when
        String result = interpreterService.parse(input);

        // then
        assertThat(result, is("[program [[repeat 4 [go, right]]]]"));
    }

    @Test
    public void parse5() throws Exception {
        // given
        String input = "program repeat 4 repeat 3 go right go left end right end end";

        // when
        String result = interpreterService.parse(input);

        // then
        assertThat(result, is("[program [[repeat 4 [[repeat 3 [go, right, go, left]], right]]]]"));
    }
}