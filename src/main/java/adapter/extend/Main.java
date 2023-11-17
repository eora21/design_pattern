package adapter.extend;

public class Main {
    public static void main(String[] args) {
        Print print = new PrintBanner("Hello");
        print.printWeek();
        print.printStrong();
    }
}
