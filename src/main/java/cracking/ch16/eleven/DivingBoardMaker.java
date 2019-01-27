package cracking.ch16.eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * K 개의 널빤지를 이어 붙여 다이빙 보드를 생성해야 한다. 가능한 다이빙 보드의 길이를 모두 구하라
 * 널빤지는 길이가 긴 것과 짧은 것 두 종류가 있다.
 */
public class DivingBoardMaker {

    public static final int LONG_BOARD = 3;
    public static final int SMALL_BOARD = 1;

    public List<Integer> calculate(int k) {
        if(k == 0) {
            return new ArrayList<>(Arrays.asList(0));
        }

        List<Integer> prevResult = calculate(k - 1);
        List<Integer> newResult = new ArrayList<>();

        for(int each : prevResult) {
            newResult.add(each + LONG_BOARD);
            newResult.add(each + SMALL_BOARD);
        }


        return new ArrayList<>(new HashSet<>(newResult));
    }
}
