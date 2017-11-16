package cracking.ch05;

public class BitOperation {
    public String toBit(int num) {
        if(num < 0) {
            return Integer.toBinaryString(num);
        }

        String result = "";
        for(int i = 0; i < Integer.numberOfLeadingZeros((int)num); i++) {
            result += '0';
        }
        result += Integer.toBinaryString(num);

        return result;
    }

    public int logicalRightShift(int num, int shiftSize) {
        return num >>> shiftSize;
    }

    public int arithmeticRightShift(int num, int shiftSize) {
        return num >> shiftSize;
    }

    /**
     * 입력값의 i 번째 비트가 0인지 확인하는 함수
     * 1. 1을 i 만큼 좌측 시프트한다.
     * 2. 입력값과 & 연산을 수행한다.
     * 3. 해당값이 0인지 체크. 입력값의 i번째 비트가 0이라면 0일 것이고, 아니면 i 번째 비트는 1일 것이다.
     * @param num
     * @param i
     * @return
     */
    public boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    /**
     * 입력값의 i 번째 비트를 1로 변경한다.
     * 다른 비트값에는 영향을 미치지 않는다.
     * @param num
     * @param i
     * @return
     */
    public int setBit(int num, int i) {
        return num | (1 << i);
    }

    /**
     * i 번째 비트값을 0으로 변경한다.
     * @param num
     * @param i
     * @return
     */
    public int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    public int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }
}
