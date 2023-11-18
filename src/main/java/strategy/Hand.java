package strategy;

import java.util.Arrays;

public enum Hand {
    SCISSORS("가위", 0),
    ROCK("바위", 1),
    PAPER("보", 2);

    private final String name;
    private final int value;

    Hand(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static Hand getHand(int value) {
        return Arrays.stream(Hand.values())
                .filter(hand -> hand.value == value)
                .findAny()
                .orElseThrow();
    }

    public boolean isWin(Hand otherHand) {
        return fight(otherHand) == 1;
    }

    public boolean isLose(Hand otherHand) {
        return fight(otherHand) == 2;
    }

    private int fight(Hand otherHand) {
        int mod = (this.value - otherHand.value) % 3;

        if (mod < 0) {
            mod += 3;
        }

        return mod;
    }

    public String getName() {
        return name;
    }
}
