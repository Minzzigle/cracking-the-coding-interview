package pattern.JU.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hand
 *
 * @author jongUn
 * @since 2017. 04. 30.
 */
public enum Hand {
	ROCK(0, "주먹"),
	SCISSORS(1, "가위"),
	PAPER(2, "보");

	private final int value;
	private final String desc;

	private Hand(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}

	public List<Hand> getRestHands(Hand h) {
		Hand[] list = Hand.values();
		List<Hand> result = new ArrayList<>();
		for (int i =0; i<list.length; i++) {
			if(list[i] != h) {
				result.add(list[i]);
			}
		}

		return result;
	}

	public static Hand findByValue(int value) {
		Hand[] list = Hand.values();
		for (int i =0; i<list.length; i++) {
			if(list[i].getValue() == value) {
				return list[i];
			}
		}

		// 없으면 주먹을 디폴트로 한다.
		return Hand.ROCK;
	}

	private boolean isWin(Hand h) {
		return ((getValue() + 1) % 3) == h.getValue();
	}

	public boolean isStrongerThan(Hand h) {
		return isWin(h);
	}

	public boolean isWeakerThan(Hand h) {
		return !isWin(h);
	}
}
