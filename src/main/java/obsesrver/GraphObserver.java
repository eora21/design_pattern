package obsesrver;

public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("*".repeat(numberGenerator.getNumber()));
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignore) {

        }
    }
}
