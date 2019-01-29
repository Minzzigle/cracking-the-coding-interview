package cracking.ch01.four;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * PalindromeFinder
 *
 * @author jongUn
 * @since 2019. 01. 29.
 */
public class PalindromeFinder {

	public boolean find(String input) {

		if(StringUtils.isEmpty(input)) {
			return true;
		}

		Map<Character, Integer> countMap = new HashMap<>();

		for(char each : input.toCharArray()) {
			if(each == ' ') {
				continue;
			}

			if(countMap.containsKey(each)) {
				countMap.put(each, countMap.get(each) + 1);
			} else {
				countMap.put(each, 1);
			}
		}

		int oddCount = 0;

		for(Character eachKey : countMap.keySet()) {
			Integer count = countMap.get(eachKey);

			if(count == null) {
				return false;
			}

			if(count % 2 == 0) {
				continue;
			}

			if(oddCount > 0) {
				return false;
			} else {
				oddCount++;
			}

		}


		return true;
	}

}
