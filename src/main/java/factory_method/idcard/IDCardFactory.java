package factory_method.idcard;

import factory_method.framework.Factory;
import factory_method.framework.Product;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class IDCardFactory extends Factory {
    private static final AtomicInteger ATOMIC_ID_GENERATOR = new AtomicInteger();
    private final Map<Integer, String> idNumberAndOwnerName = new HashMap<>();
    @Override
    protected Product createProduct(String ownerName) {
        int idNumber = ATOMIC_ID_GENERATOR.incrementAndGet();
        idNumberAndOwnerName.put(idNumber, ownerName);
        return new IDCard(ownerName, idNumber);
    }

    @Override
    protected void resisterProduct(Product product) {
        System.out.println(product+ "을 등록했습니다.");
    }
}
