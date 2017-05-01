package pattern.JU.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * ProbStrategy
 *
 * @author jongUn
 * @since 2017. 04. 30.
 */
public class ProbStrategy implements Strategy{
	private Random random = new Random();
	private Hand prevHand = Hand.ROCK;
	private Hand currentHand = Hand.ROCK;
	private Map<Hand, Map<Hand, Integer>> history = new HashMap<>();

	public ProbStrategy() {
		initHistory();
	}

	private void initHistory() {
		for(Hand h : Hand.values()) {
			Map<Hand, Integer> map = new HashMap<>();
			for(Hand h2 : Hand.values()) {
				map.put(h2, 1);
			}
			history.put(h, map);
		}
	}

	@Override
	public Hand nextHand() {
		Map<Hand, Integer> prevHistory = history.get(prevHand);

		int sum = prevHistory.values().stream().mapToInt(i -> i.intValue()).sum();
		int bet = random.nextInt(sum);

		Hand hand = findHandByBet(bet);

		prevHand = currentHand;
		currentHand = hand;
		return hand;
	}

	private Hand findHandByBet(int bet) {
		Hand hand;
		if (bet < history.get(currentHand).get(Hand.ROCK)) {
			hand = Hand.ROCK;
		} else if (bet < history.get(currentHand).get(Hand.ROCK) + history.get(currentHand).get(Hand.SCISSORS)) {
			hand = Hand.SCISSORS;
		} else {
			hand = Hand.PAPER;
		}
		return hand;
	}

	@Override
	public void study(boolean win) {
		Map<Hand, Integer> prevHistory = history.get(prevHand);

		if(win) {
			Integer value = prevHistory.get(currentHand);
			prevHistory.put(currentHand, ++value);
		} else {
			List<Hand> restHands = prevHand.getRestHands(prevHand);

			for(Hand h : restHands) {
				Integer value = prevHistory.get(h);
				prevHistory.put(h, ++value);
			}
		}

		history.put(prevHand, prevHistory);
	}
}
