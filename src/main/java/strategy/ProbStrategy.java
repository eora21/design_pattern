package strategy;

import java.util.Arrays;
import java.util.Random;

public class ProbStrategy implements Strategy {
    private final Random random = new Random();
    private int preHandValue = 0;
    private int currentHandValue = 0;
    private int[][] history = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    @Override
    public Hand nextHand() {
        preHandValue = currentHandValue;
        currentHandValue = calculateNewHandValue();
        return Hand.getHand(currentHandValue);
    }

    private int calculateNewHandValue() {
        int bet = random.nextInt(getSum(currentHandValue));

        if ((bet -= history[currentHandValue][0]) < 0) {
            return 0;
        }

        if (bet < history[currentHandValue][0]) {
            return 1;
        }

        return 2;
    }

    private int getSum(int currentHandValue) {
        return Arrays.stream(history[currentHandValue])
                .sum();
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[preHandValue][currentHandValue] += 1;
            return;
        }

        history[preHandValue][(currentHandValue + 1) % 3]++;
        history[preHandValue][(currentHandValue + 2) % 3]++;
    }
}
