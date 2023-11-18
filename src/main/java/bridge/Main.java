package bridge;

public class Main {
    public static void main(String[] args) {
        new Display(new StringDisplayImpl("hi"))
                .display();
        new Display(new StringDisplayImpl("hello"))
                .display();
        new CountDisplay(new StringDisplayImpl("how r u?"))
                .multiDisplay(5);
    }
}
