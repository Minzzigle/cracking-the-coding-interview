package pattern.dayoungle.adapter;

public class PrintBannerDelegation extends AbstractPrint{
    private Banner banner;

    public PrintBannerDelegation(String str) {
        this.banner = new Banner(str);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
