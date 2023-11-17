package prototype;

import prototype.framework.Product;

public class UnderlinePen extends Product {
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
}
