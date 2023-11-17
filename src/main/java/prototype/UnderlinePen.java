package prototype;

import prototype.framework.Product;

public class UnderlinePen implements Product {
    private final char decoCh;

    public UnderlinePen(char decoCh) {
        this.decoCh = decoCh;
    }

    @Override
    public void use(String s) {
        System.out.println(s);
        System.out.println(createDecoLine(s.length()));
    }

    private String createDecoLine(int length) {
        return String.valueOf(decoCh).repeat(length);
    }

    @Override
    public Product createCopy() {
        try {
            return (Product) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
