package strategy;

public class Main {
    public static void main(String[] args) {
        Player kim = new Player("KIM", new WiningStrategy());
        Player lee = new Player("LEE", new ProbStrategy());

        for (int i = 0; i < 10_000; i++) {
            Hand kimHand = kim.nextHand();
            System.out.println(kimHand);
            Hand leeHand = lee.nextHand();
            System.out.println(leeHand);

            if (kimHand.isWin(leeHand)) {
                kim.win();
                lee.lose();
                System.out.println("WINNER: " + kim.getLog());
                continue;
            }

            if (kimHand.isLose(leeHand)) {
                kim.lose();
                lee.win();
                System.out.println("WINNER: " + lee.getLog());
                continue;
            }

            kim.even();
            lee.even();
            System.out.println("EVEN");
        }

        System.out.println("RESULT");
        System.out.println(kim.getLog());
        System.out.println(lee.getLog());
    }
}
