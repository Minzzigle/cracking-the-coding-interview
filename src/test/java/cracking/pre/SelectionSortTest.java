package cracking.pre;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SelectionSortTest {

    private SelectionSort selectionSort;

    @Before
    public void setUp() {
       selectionSort = new SelectionSort();
    }

    @Test
    public void sort_입력값이빈배열인경우() {
        // given
        int [] arr = {};

        // when
        selectionSort.sort(arr);

        // then
        assertThat(arr.length, is(0));
    }


    @Test
    public void sort_입력값이양수와음수가섞인경우() {
        // given
        int [] arr = {-10, 20, 14, 21, 35};

        // when
        selectionSort.sort(arr);

        // then
        SortAssertionUtils.assertIsSorted(arr);
    }
}