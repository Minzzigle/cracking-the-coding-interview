package cracking.ch05.one;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InsertBitTest {
    private InsertBit insertBit = new InsertBit();

    @Test
    public void insertBit() throws Exception {
        // given

        // when
        int result = insertBit.insertBit(32, 10, 1, 4);

        // then
        assertThat(result, is(52));
    }

    @Test
    public void insertBit_2() throws Exception {
        // given

        // when
        int result = insertBit.insertBit(63, 10, 1, 4);

        // then
        assertThat(result, is(53));
    }

}