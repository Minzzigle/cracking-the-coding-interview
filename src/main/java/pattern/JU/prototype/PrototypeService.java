package pattern.JU.prototype;

import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * PrototypeService
 *
 * @author jongUn
 * @since 2017. 04. 26.
 */
@Service
public class PrototypeService {
	private HashMap showcase = new HashMap<>();
	public void register(String name, Product proto) {
		showcase.put(name, proto);
	}

	public Product create(String protoName) {
		return ((Product)showcase.get(protoName)).createClone();
	}


}
