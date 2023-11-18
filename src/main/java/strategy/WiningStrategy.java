package strategy;

import java.util.Random;

public class WiningStrategy implements Strategy {
    private final Random random = new Random();
    private Hand prevHand;
    private boolean won = false;

    @Override
    public Hand nextHand() {
        if (won) {
            return prevHand;
        }

        prevHand = Hand.getHand(random.nextInt(3));
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
