package prototype;

import prototype.framework.Product;

public class MessageBox implements Product {
    private final char decoCh;

    public MessageBox(char decoCh) {
        this.decoCh = decoCh;
    }

    @Override
    public void use(String s) {
        System.out.println(createDecoLine(s.length()));
        System.out.println(decoCh + s + decoCh);
        System.out.println(createDecoLine(s.length()));
    }

    private String createDecoLine(int length) {
        return String.valueOf(decoCh).repeat(length + 2);
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
