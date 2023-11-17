package prototype;

import prototype.framework.Product;

public class MessageBox extends Product {
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
}
