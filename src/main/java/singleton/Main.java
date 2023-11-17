package singleton;

public class Main {
    public static void main(String[] args) {
        Singleton firstInstance = Singleton.getInstance();
        Singleton secondInstance = Singleton.getInstance();

        System.out.println(firstInstance == secondInstance);
    }
}
