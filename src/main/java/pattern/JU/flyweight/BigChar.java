package pattern.JU.flyweight;

/**
 * BigChar
 *
 * @author jongUn
 * @since 2017. 05. 07.
 */
public class BigChar {
	private char charName;
	private String fontData;

	public BigChar(char charName) {
		this.charName = charName;
		fontData = String.valueOf(charName);
	}

	public char getCharName() {
		return charName;
	}

	public void print() {
		System.out.println(fontData);
	}
}
