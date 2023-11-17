package adapter.extend;

public class PrintBanner extends Banner implements Print {
    public PrintBanner(String message) {
        super(message);
    }

    @Override
    public void printWeek() {
        super.showWithParen();
    }

    @Override
    public void printStrong() {
        super.showWithAster();
    }
}
