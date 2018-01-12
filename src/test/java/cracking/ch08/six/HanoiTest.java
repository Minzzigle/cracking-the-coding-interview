package cracking.ch08.six;

import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HanoiTest {
    private Hanoi hanoi = new Hanoi();

    @Test
    public void move() throws Exception {
        // given
        LinkedList<Integer> start = new LinkedList<>();
        start.add(4);
        start.add(3);
        start.add(2);
        start.add(1);
        LinkedList<Integer> mid = new LinkedList<>();
        LinkedList<Integer> end = new LinkedList<>();

        // when
        hanoi.move(4, start, mid, end);

        // then
        assertThat(end.get(0), is(4));
        assertThat(end.get(1), is(3));
        assertThat(end.get(2), is(2));
        assertThat(end.get(3), is(1));
    }

}