package memento;

import memento.game.Gamer;
import memento.game.Memento;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();

        for (int i = 0; i < 100; i++) {
            System.out.println("=== " + i + " ===");
            System.out.println("상태: " + gamer.getDescription());

            gamer.bet();

            System.out.printf("현재 소지금: %,d\n", gamer.getMoney());

            memento = updateOrRestoreMemento(gamer, memento);

            try {
                Thread.sleep(500);
            } catch (InterruptedException ignore) {
            }

            System.out.println();
        }
    }

    private static Memento updateOrRestoreMemento(Gamer gamer, Memento memento) {
        if (gamer.getMoney() > memento.getMoney()) {
            System.out.println("현재 상태 저장");
            return gamer.createMemento();
        }

        if (gamer.getMoney() < memento.getMoney() / 2) {
            System.out.println("이전 상태 복원");
            gamer.restoreMemento(memento);
        }

        return memento;
    }
}
