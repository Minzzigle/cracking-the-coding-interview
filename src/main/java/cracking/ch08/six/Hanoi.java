package cracking.ch08.six;

import java.util.LinkedList;

public class Hanoi {
    public void move(int num, LinkedList<Integer> start, LinkedList<Integer> mid, LinkedList<Integer> dest) {
        // 재귀 종료조건. n==1 일때는 그냥 들어서 dest에 놓으면 된다.
        if(num == 1) {
            Integer item = start.removeLast();
            dest.add(item);
            return;
        }

        // 1. 재귀를 통해 start > mid 로 n-1개 원반을 옮긴다.
        move(num -1, start, dest, mid);
        // 2. n번째 원반을 dist로 옮긴다.
        Integer target = start.removeLast();
        dest.add(target);
        // 3. 재귀로 mid > dest 로 원반을 옮긴다.
        move(num -1, mid, start, dest);
    }

}
