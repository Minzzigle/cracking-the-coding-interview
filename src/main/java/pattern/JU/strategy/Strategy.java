package pattern.JU.strategy;

/**
 * Strategy
 *
 * @author jongUn
 * @since 2017. 04. 30.
 */
public interface Strategy {
	Hand nextHand();
	void study(boolean win);
}
