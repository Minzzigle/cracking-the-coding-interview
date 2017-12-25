package cracking.ch01.two;

import java.util.*;

/**
 * SameSentence
 *
 * @author jongUn
 * @since 2017. 12. 25.
 */
public class SameSentence {

	/**
	 * 두 문자열이 같은 문자열인지 체크한다.
	 * 1. 두 문자열을 정렬한다.
	 * 2. 정렬한 문자열을 순회하면서 두 문자열이 완전히 동일한지 체크한다.
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isSameSentence(String s1, String s2) {
		// validate check
		if(s1.length() != s2.length()) {
			return false;
		}

		List<Character> s1List = toList(s1);
		List<Character> s2List = toList(s2);

		Collections.sort(s1List);
		Collections.sort(s2List);

		for(int i = 0; i<s1List.size(); i++) {
			if(s1List.get(i) != s2List.get(i)) {
				return false;
			}
		}

		return true;
	}


	private List<Character> toList(String input) {
		List<Character> result = new ArrayList<>();
		for(int i = 0; i<input.length(); i++) {
			result.add(input.charAt(i));
		}

		return result;
	}

	/**
	 * Map을 사용하여 두 문자열이 순열인지 확인한다.
	 * Time Comp : O(n)
	 * Space Comp : O(n)
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isSameSentenceByMap(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<>();

		for(int i = 0; i<s1.length(); i++) {
			Character key = s1.charAt(i);
			if(map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}

		for(int j = 0; j<s2.length(); j++) {
			Character key = s2.charAt(j);
			if(map.containsKey(key)) {
				if(map.get(key) - 1 == 0) {
					map.remove(key);
				} else {
					map.put(key, map.get(key) - 1);
				}
			} else {
				return false;
			}
		}

		if(map.keySet().size() != 0) {
			return false;
		}

		return true;
	}


}
