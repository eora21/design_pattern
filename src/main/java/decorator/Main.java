package decorator;

public class Main {
    public static void main(String[] args) {
        Display stringDisplay = new StringDisplay("Hello, world.");
        Display sideBorder = new SideBorder(stringDisplay, '#');
        Display fullBorder = new FullBorder(sideBorder);

        stringDisplay.show();
        sideBorder.show();
        fullBorder.show();

        Display complex = new SideBorder(
                new FullBorder(new FullBorder(
                                new SideBorder(new FullBorder(stringDisplay), '*')))
                , '/'
        );

        complex.show();
    }
}
