package memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
    private static final String[] fruitsName = {
            "사과", "포도", "바나나", "오렌지"
    };

    private final Random random = new Random();
    private List<String> fruits = new ArrayList<>();
    private int money;

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;

        switch(dice) {
            case 1 -> {
                money += 100;
                System.out.println("소지금 증가");
            }
            case 2 -> {
                money /= 2;
                System.out.println("소지금 절반");
            }
            case 6 -> {
                String fruit = getFruit();
                System.out.println(fruit +" 받음");
                fruits.add(fruit);
            }
            default -> System.out.println("변동 사항 없음");
        }
    }

    private String getFruit() {
        String fruitName = fruitsName[random.nextInt(fruitsName.length)];
        if (random.nextBoolean()) {
            return "맛있는 " + fruitName;
        }

        return fruitName;
    }

    public Memento createMemento() {
        Memento memento = new Memento(money);

        fruits.stream()
                .filter(fruit -> fruit.startsWith("맛있는"))
                .forEach(memento::addFruit);

        return memento;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    public String getDescription() {
        return String.format("money = %,d, fruits = %s", money, fruits);
    }
}
