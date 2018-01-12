package cracking.ch08.five;

/**
 * Multiply
 *
 * @author jongUn
 * @since 2018. 01. 10.
 */
public class Multiply {
	public int multiply(int a, int b) {
		if(b == 0) {
			return 0;
		}
		int now = 1;
		int pre = 0;
		int pow = 0;
		while(true) {
			pre = now;
			now = now << 1;
			if(now > b) {
				break;
			}
			pow++;
		}

		return multiply(a, b - pre) + (a << pow);
	}

}
