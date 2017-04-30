package pattern.JU.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * ProbStrategy
 *
 * @author jongUn
 * @since 2017. 04. 30.
 */
public class ProbStrategy implements Strategy{
	private Random random;
	private Hand prevHand;
	private Hand currentHand;
	private Map<Hand, Map<Hand, Integer>> history = new HashMap<>();

	public ProbStrategy() {
		initHistory();
	}

	private void initHistory() {
		for(Hand h : Hand.values()) {
			for(Hand h2 : Hand.values()) {
				Map<Hand, Integer> map = new HashMap<>();
				map.put(h2, 0);
				history.put(h, map);
			}
		}
	}

	@Override
	public Hand nextHand() {
		Map<Hand, Integer> prevHistory = history.get(prevHand);

//		int bet = random.nextInt(sum);
//		Hand hand;
//		if (bet < history[prevHand.getValue()][0]) {
//			hand = Hand.findByValue(0);
//		} else if (bet < history[prevHand.getValue()][0] + history[prevHand.getValue()][1]) {
//			hand = Hand.findByValue(1);
//		} else {
//			hand = Hand.findByValue(2);
//		}

		prevHand = currentHand;
		currentHand = hand;
		return hand;
	}

	@Override
	public void study(boolean win) {
		Map<Hand, Integer> prevHistory = history.get(prevHand);

		if(win) {
			Integer value = prevHistory.get(currentHand);
			prevHistory.put(currentHand, ++value);
			return;
		}

		List<Hand> restHands = prevHand.getRestHands();

		for(Hand h : restHands) {
			Integer value = prevHistory.get(h);
			prevHistory.put(h, ++value);
		}
		return;
	}
}
