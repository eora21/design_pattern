package adapter.extend;

public class Banner {
    private final String message;

    public Banner(String message) {
        this.message = message;
    }

    public void showWithParen() {
        System.out.printf("(%s)\n", message);
    }

    public void showWithAster() {
        System.out.printf("*%s*\n", message);
    }
}
