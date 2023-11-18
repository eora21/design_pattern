package bridge;

public class StringDisplayImpl extends DisplayImpl {
    private final String message;
    private final int length;

    public StringDisplayImpl(String message) {
        this.message = message;
        this.length = message.length();
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + message + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.println("+" + "-".repeat(length) + "+");
    }
}
