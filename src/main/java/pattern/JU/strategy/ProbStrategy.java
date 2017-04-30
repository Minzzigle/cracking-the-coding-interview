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
	private int[][] history = {
		{1,1,1},
		{1,1,1},
		{1,1,1}
	};

	@Override
	public Hand nextHand() {
		int[] list = history[prevHand.getValue()];
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i];
		}

		int bet = random.nextInt(sum);
		Hand hand;
		if (bet < history[prevHand.getValue()][0]) {
			hand = Hand.findByValue(0);
		} else if (bet < history[prevHand.getValue()][0] + history[prevHand.getValue()][1]) {
			hand = Hand.findByValue(1);
		} else {
			hand = Hand.findByValue(2);
		}

		prevHand = currentHand;
		currentHand = hand;
		return hand;
	}

	@Override
	public void study(boolean win) {
		int prevValue = prevHand.getValue();

		if(win) {
			history[prevValue][currentHand.getValue()]++;
		}

		history[prevValue][(currentHand.getValue() + 1) % 3]++;
		history[prevValue][(currentHand.getValue() + 2) % 3]++;
		return;
	}
}
