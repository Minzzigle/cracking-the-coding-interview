package cracking.ch03.two;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MinStackTest {
    @Test
    public void min() throws Exception {
        // given

        // when
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(3);
        int result = minStack.min();

        minStack.push(4);
        minStack.push(1);

        int result2 = minStack.min();

        // then
        assertThat(result, is(2));
        assertThat(result2, is(1));
    }

    @Test
    public void minWhenPop() throws Exception {
        // given

        // when
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(3);
        minStack.push(2);

        int result = minStack.min();

        minStack.pop();

        int result2 = minStack.min();

        // then
        assertThat(result, is(2));
        assertThat(result2, is(3));
    }

}