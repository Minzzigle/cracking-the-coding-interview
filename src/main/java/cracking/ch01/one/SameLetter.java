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
	public boolean hasSameLetter(String input) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i<input.length(); i++) {
			if(map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
				continue;
			}
			map.put(input.charAt(i), 1);
		}

		for(Character key : map.keySet()) {
			Integer count = map.get(key);
			if(count > 1) {
				return true;
			}
		}

		return false;
	}


}
