package cracking.ch05;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BitOperationTest {
    private BitOperation bitOperation = new BitOperation();

    @Test
    public void toBit() throws Exception {
        // given

        // when
        String result = bitOperation.toBit(1024);

        // then
        assertThat(result.length(), is(32));
    }

    @Test
    public void toBit_maxValue() throws Exception {
        // given

        // when
        String result = bitOperation.toBit(Integer.MAX_VALUE);

        // then
        assertThat(result.length(), is(32));
        assertThat(result, is("01111111111111111111111111111111"));
    }

    @Test
    public void toBit_minValue() throws Exception {
        // given

        // when
        String result = bitOperation.toBit(-1);

        // then
        assertThat(result.length(), is(32));
        System.out.println(result);
        assertThat(result, is("10000000000000000000000000000000"));
    }

    @Test
    public void logicalRightShift() throws Exception {
        // given

        // when
        System.out.println("toBit : " + bitOperation.toBit(-75));
        int result = bitOperation.logicalRightShift(-75, 1);

        // then
        System.out.println("result: " + bitOperation.toBit(result));
        assertThat(bitOperation.toBit(result), is("01111111111111111111111111011010"));
    }

    @Test
    public void arithmeticRightShift() throws Exception {
        // given

        // when
        System.out.println("toBit : " + bitOperation.toBit(-75));
        int result = bitOperation.arithmeticRightShift(-75, 1);

        // then
        System.out.println("result: " + bitOperation.toBit(result));
        assertThat(bitOperation.toBit(result), is("11111111111111111111111111011010"));
    }

    @Test
    public void getBit() throws Exception {
        // given

        // when
        boolean result = bitOperation.getBit(7, 2);
        boolean result2 = bitOperation.getBit(7, 3);

        // then
        assertThat(result, is(true));
        assertThat(result2, is(false));
    }

    @Test
    public void setBit() throws Exception {
        // given

        // when
        int result = bitOperation.setBit(7, 3);
        int result2 = bitOperation.setBit(7, 2);

        // then
        assertThat(result, is(15));
        assertThat(result2, is(7));
    }


}