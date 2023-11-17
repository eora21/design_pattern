package template_method;

public class StringDisplay implements AbstractDisplay {
    private final String message;
    private final int length;

    public StringDisplay(String message) {
        this.message = message;
        this.length = message.length();
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + message + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.println("+" + "-".repeat(length) + "+");
    }
}
