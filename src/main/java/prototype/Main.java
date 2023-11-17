package prototype;

import prototype.framework.Manager;
import prototype.framework.Product;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('-');
        MessageBox warningBox = new MessageBox('*');
        MessageBox slashBox = new MessageBox('/');

        manager.register("Strong Message", underlinePen);
        manager.register("Warning Box", warningBox);
        manager.register("Slash Box", slashBox);

        Product firstProduct = manager.create("Strong Message");
        firstProduct.use("Hello, world.");

        Product secondProduct = manager.create("Warning Box");
        secondProduct.use("Hello, world.");

        Product thirdProduct = manager.create("Slash Box");
        thirdProduct.use("Hello, world.");
    }
}
