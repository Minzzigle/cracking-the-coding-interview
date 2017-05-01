package pattern.JU.strategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pattern.Application;

import static org.junit.Assert.*;

/**
 * Created by cha45 on 2017-05-01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class StrategyServiceTest {
    @Autowired
    private StrategyService strategyService;

    @Test
    public void fight() throws Exception {
        // given

        // when
        strategyService.fight();

        // then
    }

}