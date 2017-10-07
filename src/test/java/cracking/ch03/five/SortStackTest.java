package cracking.ch03.five;

import cracking.ch03.Stack;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SortStackTest {
    @Test
    public void sort() throws Exception {
        // given
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(2);


        // when
        SortStack sortStack = new SortStack();
        Stack<Integer> result = sortStack.sort(stack);

        // then
        assertThat(result.pop(), is(1));
        assertThat(result.pop(), is(2));
        assertThat(result.pop(), is(2));
        assertThat(result.pop(), is(3));
        assertThat(result.pop(), is(4));
        assertThat(result.pop(), is(5));
    }

}