package cracking.ch08.four;

/**
 * SubSet
 * 현재 입력값의 모든 부분집합을 리턴하는 메서드. 순열을 출력하기 때문에, 순서가 다른 것도 다른 집합 원소로 간주한다.
 * input > "ab"
 * result > "a", "b", "ab", "ba"
 *
 * @author jongUn
 * @since 2018. 01. 10.
 */
public class SubSet {
	public void print(String input, String prefix) {
		if (input.length() == 0) {
			System.out.println(prefix);
			return;
		}
		System.out.println(prefix);
		for (int i = 0; i < input.length(); i++) {
			String rem = input.substring(0, i) + input.substring(i + 1);
			print(rem, prefix + input.charAt(i));
		}
	}
}
