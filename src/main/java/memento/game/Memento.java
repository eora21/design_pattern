package memento.game;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private final List<String> fruits = new ArrayList<>();
    private int money;

    Memento(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    List<String> getFruits() {
        return new ArrayList<>(fruits);
    }
}
