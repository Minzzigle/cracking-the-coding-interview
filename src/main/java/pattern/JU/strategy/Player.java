package pattern.JU.strategy;

/**
 * Player
 *
 * @author jongUn
 * @since 2017. 04. 30.
 */
public class Player {
	private Strategy strategy;
	private String name;
	private int winCount;
	private int gameCount;
	private int loseCount;

	public Player(String name, Strategy strategy) {
		this.name = name;
		this.strategy = strategy;
	}

	public Hand nextHand() {
		return strategy.nextHand();
	}

	public void win() {
		strategy.study(true);
		gameCount++;
		winCount++;
	}

	public void even() {
		gameCount++;
	}

	public void lose() {
		strategy.study(false);
		gameCount++;
		loseCount++;
	}

	public String printStatus() {
		return "[" + name + ":" + gameCount + "game, " + winCount + " win, " + loseCount + " lose]";
	}

	public String getName() {
		return name;
	}
}
