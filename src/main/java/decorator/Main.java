package decorator;

public class Main {
    public static void main(String[] args) {
        Display stringDisplay = new StringDisplay("Hello, world.");
        Display upDownBorder = new UpDownBorder(stringDisplay, '-');
        Display sideBorder = new SideBorder(upDownBorder, '*');

        stringDisplay.show();
        upDownBorder.show();
        sideBorder.show();

        Display complex = new FullBorder(
                new UpDownBorder(
                        new SideBorder(
                                new UpDownBorder(
                                        new SideBorder(stringDisplay, '*')
                                        , '='),
                                '|'),
                        '/')
                );

        complex.show();
    }
}
