package cracking.ch10.five;

import java.util.List;

import static cracking.ch10.five.WordDic.Status.HIGH;
import static cracking.ch10.five.WordDic.Status.LOW;

public class WordDic {
    public int find(String target, List<String> dicArray) {
        if(target == null || dicArray.size() == 0) {
            return Integer.MIN_VALUE;
        }

        int midIdx = dicArray.size() / 2;

        if(dicArray.get(midIdx).equals(target)) {
            return midIdx;
        }

        Status status = calculate(dicArray.get(midIdx), target, dicArray);

        if(status == LOW) {
            return find(target, dicArray.subList(0, midIdx - 1));
        }

        if(status == HIGH) {
            return find(target, dicArray.subList(midIdx + 1, dicArray.size() - 1));
        }

        return Integer.MIN_VALUE;
    }

    private Status calculate(String midValue, String target, List<String> dicArray) {
        if(midValue.equals("")) {
            // midValue = findMidValue();
        }

        int i = 0;
        while(true) {
           if((int)midValue.charAt(i) > (int)target.charAt(i)) {
                return LOW;
           } else if((int)midValue.charAt(i) < (int)target.charAt(i)) {
               return HIGH;
           }

        }


    }

    private int findMidValue(String midValue, List<String> dicArray) {
        return 0;

    }

    enum Status {
        LOW, HIGH
    }
}
