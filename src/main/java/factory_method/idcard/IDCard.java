package factory_method.idcard;

import factory_method.framework.Product;

public class IDCard extends Product {
    private final String ownerName;

    public IDCard(String ownerName) {
        System.out.println(ownerName + "의 카드를 만듭니다.");
        this.ownerName = ownerName;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return "[IDCard:" + ownerName + "]";
    }
}
