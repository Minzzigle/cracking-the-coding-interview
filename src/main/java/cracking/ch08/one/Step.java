package cracking.ch08.one;

import java.util.ArrayList;
import java.util.List;

/**
 * Step
 * 1,2,3 칸 올라갈 수 있을 때 remain 높이의 계단을 올라가는 경우의 수를 모두 출력하는 메서드
 *
 * @author jongUn
 * @since 2018. 01. 10.
 */
public class Step {
	public void step(int remain, List<Integer> step) {
		if(remain == 0) {
			printStep(step);
			return;
		}
		for(int j = 1; j< 4; j++) {
			if(remain - j >= 0) {
				List<Integer> s = new ArrayList<>(step);
				s.add(j);
				step(remain - j, s);
			}
		}
	}

	private void printStep(List<Integer> step) {
		for(int i = 0; i<step.size(); i++) {
			System.out.print(step.get(i) + " ");
		}
		System.out.println("");
	}
}
