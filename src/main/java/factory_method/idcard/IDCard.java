package factory_method.idcard;

import factory_method.framework.Product;
import java.util.concurrent.atomic.AtomicInteger;

public class IDCard extends Product {
    private final String ownerName;
    private final int idNumber;

    public IDCard(String ownerName, int idNumber) {
        System.out.println(ownerName + "의 카드를 만듭니다.");
        this.ownerName = ownerName;
        this.idNumber = idNumber;
    }

    public int getIdNumber() {
        return idNumber;
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
