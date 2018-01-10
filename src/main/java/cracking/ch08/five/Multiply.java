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
		int underValue = 0;
		int idx = 0;
		while(underValue <= b) {
			underValue = (int)Math.pow(2, idx);
			idx++;
		}
		idx = idx - 2;

		underValue = underValue >> 1;
		return multiply(a, b - underValue) + (a << idx);


	}

}
