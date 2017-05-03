package pattern.dayoungle.adapter;

public class PrintBannerInherit extends Banner implements InterfacePrint {

    public PrintBannerInherit(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
