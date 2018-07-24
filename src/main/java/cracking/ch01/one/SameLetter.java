package cracking.ch01.one;

import java.util.HashMap;
import java.util.Map;

/**
 * SameLetter
 *
 * @author jongUn
 * @since 2017. 12. 22.
 */
public class SameLetter {
	public boolean hasSameLetter(char [] input) {
		if(input.length == 0) {
			return false;
		}

		boolean [] duplicatedBoolArray = new boolean[256];

		for(int i = 0; i<input.length; i++) {
			if(duplicatedBoolArray[(int)input[i]] == true) {
				return true;
			}

			duplicatedBoolArray[(int)input[i]] = true;
		}

		return false;
	}

}
