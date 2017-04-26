package pattern.JU.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Product
 *
 * @author jongUn
 * @since 2017. 04. 26.
 */
public interface Product extends Cloneable{
	Map<String, String> maps = new HashMap<>();

	String use(String s);
	Product createClone();
}
