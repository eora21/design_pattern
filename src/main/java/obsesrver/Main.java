package obsesrver;

public class Main {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Observer digitObserver = new DigitObserver();
        Observer graphObserver = new GraphObserver();
        numberGenerator.addObserver(digitObserver);
        numberGenerator.addObserver(graphObserver);
        numberGenerator.execute();
    }
}
