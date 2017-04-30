package pattern.JU.strategy;

import java.util.Random;

/**
 * WinningStrategy
 *
 * @author jongUn
 * @since 2017. 04. 30.
 */
public class WinningStrategy implements Strategy{
	private Random random;
	private boolean won;
	private Hand prevHand;


	@Override
	public Hand nextHand() {
		if(won) {
			return prevHand;
		}

		return Hand.findByValue(random.nextInt(3));
	}

	@Override
	public void study(boolean win) {
		this.won = win;
	}
}
