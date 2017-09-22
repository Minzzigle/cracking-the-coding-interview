package cracking.ch02;

import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * SumList_02_05
 *
 * @author jongUn
 * @since 2017. 09. 22.
 *
 */
public class SumList_02_05 {
	public LinkedList solve(LinkedList list1, LinkedList list2) {
		if(list1.head == null || list2.head == null) {
			return null;
		}

		Node n1 = list1.head;
		Node n2 = list2.head;
		String result = "";
		Integer upper = null;

		while(n1 != null && n2 != null) {
			String sum = null;
			if(upper == null) {
				sum = String.valueOf(n1.data + n2.data);
			} else {
				sum = String.valueOf(n1.data + n2.data + upper);
			}

			if(sum.length() == 1) {
				result += sum;
			} else {
				upper = Integer.parseInt(String.valueOf(sum.charAt(0)));
				if(sum.charAt(1) != '0') {
					result += sum.charAt(1);
				}

			}
			n1 = n1.next;
			n2 = n2.next;
		}

		LinkedList result2 = new LinkedList();

		for(int i =0; i<result.length(); i++) {
			result2.appendToTail(Integer.parseInt(String.valueOf(result.charAt(i))));
		}

		return result2;
	}
}
