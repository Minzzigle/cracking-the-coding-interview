package pattern.JU.flyweight;

import org.springframework.stereotype.Service;

/**
 * FlyWeightService
 *
 * @author jongUn
 * @since 2017. 05. 07.
 */
@Service
public class FlyWeightService {
	public BigString findBigString(String input) {
		// print
		BigString bigString = new BigString(input);
		bigString.print();

		return bigString;
	}

	public BigString findBigStringWithoutSync(String input) {
		BigString bigString = new BigString(input, false);

		return bigString;
	}
}
