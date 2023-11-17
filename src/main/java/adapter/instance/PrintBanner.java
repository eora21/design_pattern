package adapter.instance;

public class PrintBanner extends Print {
    private final Banner banner;

    public PrintBanner(String message) {
        this.banner = new Banner(message);
    }

    @Override
    void printWeek() {
        banner.showWithParen();
    }

    @Override
    void printStrong() {
        banner.showWithAster();
    }
}
