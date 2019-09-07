package cracking.pre;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InsertionSortTest {

    private InsertionSort insertionSort;

    @Before
    public void setUp() {
        insertionSort = new InsertionSort();
    }

    @Test
    public void sort_입력값이빈배열인경우() {
        // given
        int [] arr = {};

        // when
        insertionSort.sort(arr);

        // then
        assertThat(arr.length, is(0));
    }


    @Test
    public void sort_입력값이양수와음수가섞인경우() {
        // given
        int [] arr = {-10, 20, 14, 21, 35};

        // when
        insertionSort.sort(arr);

        // then
        SortAssertionUtils.assertIsSorted(arr);
    }
}