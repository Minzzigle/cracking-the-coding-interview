package pattern.JU.flyweight;

/**
 * BigString
 *
 * @author jongUn
 * @since 2017. 05. 07.
 */
public class BigString {
	private BigChar[] bigChars;

	public BigString(String input) {
		bigChars = new BigChar[input.length()];
		BigCharFactory factory = BigCharFactory.newInstance();
		for(int i = 0; i<input.length(); i++) {
			this.bigChars[i] = factory.getBigChar(input.charAt(i));
		}
	}

	public BigString(String input, boolean isSync) {
		bigChars = new BigChar[input.length()];
		BigCharFactory factory = BigCharFactory.newInstance();
		for(int i = 0; i<input.length(); i++) {
			this.bigChars[i] = factory.getBigCharWithoutSync(input.charAt(i));
		}
	}

	public void print() {
		for(int i =0; i<bigChars.length; i++) {
			bigChars[i].print();
		}
	}

	public BigChar[] getBigChars() {
		return bigChars;
	}
}
