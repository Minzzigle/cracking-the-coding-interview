package cracking.ch16.six;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AbsTwoArrayTest {

    private AbsTwoArray absTwoArray;

    @Before
    public void setUp() {
        absTwoArray = new AbsTwoArray();
    }

    @Test
    public void calculate_입력값중하나가빈경우() {
        // given

        // when
        int result = absTwoArray.calculate(null, new int []{1});

        // then
        assertThat(result, is(0));
    }

    @Test
    public void calculate_입력값중하나가음수인경우() {
        // given

        // when
        int result = absTwoArray.calculate(new int []{1}, new int []{-2});

        // then
        assertThat(result, is(3));
    }

    @Test
    public void calculate_입력값이둘다정상적으로존재하는경우() {
        // given

        // when
        int result = absTwoArray.calculate(new int []{1,2,3}, new int [] {4, 5});

        // then
        assertThat(result, is(1));
    }
}