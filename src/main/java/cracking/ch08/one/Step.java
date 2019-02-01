package cracking.ch08.one;

import java.util.Arrays;

/**
 * Step
 * 1,2,3 칸 올라갈 수 있을 때 remain 높이의 계단을 올라가는 경우의 수를 모두 출력하는 메서드
 *
 * @author jongUn
 * @since 2018. 01. 10.
 */
public class Step {
    int [] cache;

	public Step(int size) {
		this.cache = new int[size];
		Arrays.fill(cache, -1);
	}

	public int step(int remain) {
		if(remain < 0) {
			return 0;
		} else if(remain == 0) {
			return 1;
		} else if(cache[remain] != -1) {
			return cache[remain];
		} else {
			cache[remain] = step(remain - 3) + step(remain - 2) + step(remain - 1);
			return cache[remain];
		}
	}

}
