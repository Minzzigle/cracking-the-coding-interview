package pattern.JU.adapter;

/**
 * Created by cha45 on 2017-04-20.
 */

public class Banner {
    private String s;

    public Banner(String s) {
        this.s = s;
    }

    public String showWithParen() {
        return "(" + this.s + ")";
    }

    public String showWithAster() {
        return "*" + this.s + "*";
    }
}
