package pattern.JU.strategy;

import org.springframework.stereotype.Service;

/**
 * StrategyService
 *
 * @author jongUn
 * @since 2017. 04. 30.
 */
@Service
public class StrategyService {
    public void fight() {
        Player player1 = new Player("두리", new WinningStrategy());
        Player player2 = new Player("하나", new ProbStrategy());
        for(int i = 0; i< 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if(nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + player1.getName());
                player1.win();
                player2.lose();
            } else if(nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner:" + player2.getName());
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }

        System.out.println("Total Result :");
        System.out.println(player1.printStatus());
        System.out.println(player2.printStatus());
        /*
        [두리:10000game, 2988 win, 4262 lose]
        [하나:10000game, 4262 win, 2988 lose]
        같은 전략을 쓰면 승률이 50%가 나온다.
         */
    }
}
