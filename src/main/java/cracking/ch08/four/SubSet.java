package cracking.ch08.four;

import java.util.ArrayList;
import java.util.List;

/**
 * SubSet
 * 현재 입력값의 모든 부분집합을 리턴하는 메서드.
 * input > "ab"
 * result > "a", "b", "ab"
 *
 * @author jongUn
 * @since 2018. 01. 10.
 */
public class SubSet {
	public List<String> print(String input) {
		if(input.length() == 0) {
			return new ArrayList();
		}

		List<String> result = print(input.substring(0, input.length() - 1));
		Character target = input.charAt(input.length() - 1);

		int now = result.size();
		for(int i = 0; i<now; i++) {
			result.add(result.get(i) + target);
		}
		result.add(String.valueOf(target));

		return result;
	}
}
