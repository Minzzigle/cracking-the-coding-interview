package pattern.JU.prototype;


/**
 * MessageBox
 *
 * @author jongUn
 * @since 2017. 04. 26.
 */
public class MessageBox implements Product {
	private String deco;

	public MessageBox(String deco) {
		this.deco = deco;
	}

	@Override
	public String use(String s) {
		return deco + s + deco;
	}

	@Override
	public Product createClone() {
		Product p = null;
		try {
			p = (Product)clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return p;
	}
}
