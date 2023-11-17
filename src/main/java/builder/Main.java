package builder;

public class Main {
    public static void main(String[] args) {
        Director firstDirector = new Director(new TextBuilder());
        Director secondDirector = new Director(new HTMLBuilder());

        System.out.println(firstDirector.construct());
        System.out.println(secondDirector.construct());
    }
}
