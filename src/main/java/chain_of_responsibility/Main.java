package chain_of_responsibility;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("alice");
        Support bob = new LimitSupport("bob", 100);
        Support charlie = new SpecialSupport("charlie", 429);
        Support diana = new LimitSupport("diana", 200);
        Support elmo = new OddSupport("elmo");
        Support fred = new LimitSupport("fred", 300);

        alice.setNext(bob)
                .setNext(charlie)
                .setNext(diana)
                .setNext(elmo)
                .setNext(fred);

        IntStream.iterate(0, i -> i < 500, operand -> operand + 33)
                .forEach(i -> alice.support(new Trouble(i)));
    }
}
