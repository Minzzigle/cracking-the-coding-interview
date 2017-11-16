package cracking.ch05.one;

public class InsertBit {
    public int insertBit(int n, int m, int i, int j) {
        int diff = j - i + 1;
        int mask = (-1 << (j + 1)); // j 번째 비트까지 0으로 채운다. ex) 11111110000000 .. 이런 식으로.
        mask += Math.pow(2, i) - 1; // i 번째 비트까지 1로 변경한다.

        n = n & mask; // 값이 들어갈 부분을 0으로 변경
        m = m << i; // m 뒤에 시프트를 해서 자릿수를 맞춘다.

        return n | m;
    }
}
