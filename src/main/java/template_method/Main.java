package template_method;

public class Main {
    public static void main(String[] args) {
        AbstractDisplay firstDisplay = new CharDisplay('H');
        AbstractDisplay secondDisplay = new StringDisplay("Hello, world.");

        firstDisplay.display();
        secondDisplay.display();
    }
}
