package cracking.ch10.five;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class WordDicTest {
    @Test
    public void find() throws Exception {
        // given
        String target = "one";
        List<String> dicArray = makeDicArray();

        // when
        int result = wordDic.find(target, dicArray);

        // then
        assertThat(result, is(5));
    }

    @Test
    public void find_fail() throws Exception {
        // given
        String target = "one";
        List<String> dicArray = makeDicArray();

        // when
        int result = wordDic.find(target, dicArray);

        // then
        assertThat(result, is(Integer.MIN_VALUE));
    }

    private WordDic wordDic = new WordDic();

    private List<String> makeDicArray() {
        List<String> dicArray = new ArrayList<>();
        dicArray.add("five");
        dicArray.add("");
        dicArray.add("");
        dicArray.add("four");
        dicArray.add("");
        dicArray.add("one");
        dicArray.add("");
        dicArray.add("");
        dicArray.add("three");
        dicArray.add("");
        dicArray.add("two");

        return dicArray;
    }

}