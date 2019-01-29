package cracking.ch01.three;

/**
 * StringChanger
 * 문자열에 들어있는 모든 공백을 '%20' 으로 바꿔주는 메서드
 * 모든 문자를 담을 수 있는 공간은 확보되어 있으며, 문자열에 최종 길이가 함께 주어진다.
 * 자바에서는 char array 사용
 *
 * @author jongUn
 * @since 2019. 01. 29.
 */
public class StringChanger {

	public void changeBlank(char [] input, int trueSize) {

		if(trueSize == 0) {
			return;
		}

		int blankSize = checkBlankSize(input);
		int idx = trueSize + blankSize * 2 - 1;

		for(int i = trueSize - 1; i > -1; i--) {
			if(input[i] == ' ') {
				input[idx] = '0';
				input[idx - 1] = '2';
				input[idx - 2] = '%';
				idx = idx - 3;
			} else {
				input[idx] = input[i];
				idx = idx - 1;
			}
		}
	}

	private int checkBlankSize(char[] input) {
		int result = 0;

		for(int i = 0; i<input.length; i++) {
			if(input[i] == ' ') {
				result++;
			}
		}

		return result;
	}
}
