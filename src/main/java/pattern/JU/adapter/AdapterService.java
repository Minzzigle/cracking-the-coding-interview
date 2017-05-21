package pattern.JU.adapter;

import org.springframework.stereotype.Service;

/**
 * Created by cha45 on 2017-04-20.
 */
@Service
public class AdapterService {
    private PrintBanner printBanner = new PrintBanner("input");
    private Banner banner = new Banner("nput");

    public String printWeakWithInheritance() {
        return printBanner.showWithParen();
    }

    public String printStrongWithInheritance() {
        return printBanner.showWithAster();
    }

    public String printWeakWithDelegate() {
        return banner.showWithParen();
    }

    public String printStrongWithDelegate() {
        return banner.showWithAster();
    }

}
