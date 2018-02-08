package cracking.ch10.five;

import java.util.List;

public class WordDic {
    public int find(String target, List<String> dicArray) {
        if(target == null || dicArray.size() == 0) {
            return Integer.MIN_VALUE;
        }

        int midIdx = dicArray.size() / 2;

        if(dicArray.get(midIdx).equals(target)) {
            return midIdx;
        }


        return 0;
    }

    private Status calculate(String midValue, String target, List<String> dicArray) {
        if(midValue.equals("")) {
//            midValue = findMidValue();
        }

        Character i = 0;
        int j = 0;

//        while()
        return null;
    }

    enum Status {
        LOW, HIGH
    }
}
