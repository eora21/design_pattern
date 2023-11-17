package factory_method.idcard;

import factory_method.framework.Factory;
import factory_method.framework.Product;

public class IDCardFactory extends Factory {
    @Override
    protected Product createProduct(String ownerName) {
        return new IDCard(ownerName);
    }

    @Override
    protected void resisterProduct(Product product) {
        System.out.println(product+ "을 등록했습니다.");
    }
}
