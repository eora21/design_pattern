package factory_method;

import factory_method.framework.Factory;
import factory_method.framework.Product;
import factory_method.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();

        Product firstProduct = factory.create("김씨");
        Product secondProduct = factory.create("나씨");
        Product thirdProduct = factory.create("박씨");

        firstProduct.use();
        secondProduct.use();
        thirdProduct.use();
    }
}
