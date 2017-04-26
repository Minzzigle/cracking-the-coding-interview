package pattern.JU.prototype;

/**
 * Product
 *
 * @author jongUn
 * @since 2017. 04. 26.
 */
public interface Product extends Cloneable{
	String use(String s);
	Product createClone();
}
