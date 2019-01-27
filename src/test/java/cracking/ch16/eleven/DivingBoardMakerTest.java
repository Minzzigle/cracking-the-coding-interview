package cracking.ch16.eleven;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DivingBoardMakerTest {

    private DivingBoardMaker divingBoardMaker;

    @Before
    public void setUp() {
        divingBoardMaker = new DivingBoardMaker();
    }

    @Test
    public void calculate_보드의값이0인경우() {
        // given

        // when
        List<Integer> result = divingBoardMaker.calculate(0);

        // then
        assertThat(result.size(), is(1));
        assertThat(result.get(0), is(0));
    }

    @Test
    public void calculate_보드의길이가정상적인경우() {
        // given

        // when
        List<Integer> result = divingBoardMaker.calculate(3);

        // then
        assertThat(result.size(), is(4));
        assertThat(result.contains(3),is(true));
        assertThat(result.contains(5),is(true));
        assertThat(result.contains(7),is(true));
        assertThat(result.contains(9),is(true));
    }
}