package pattern.JU.adapter;

/**
 * Created by cha45 on 2017-04-20.
 */
public class PrintBanner extends Banner implements Print{
    public PrintBanner(String s) {
        super(s);
    }

    @Override
    public String printWeak() {
        return showWithParen();
    }

    @Override
    public String printString() {
        return showWithAster();
    }
}
