package factory_method.framework;

public abstract class Factory {
    public final Product create(String ownerName) {
        Product product = createProduct(ownerName);
        resisterProduct(product);
        return product;
    }

    protected abstract Product createProduct(String ownerName);
    protected abstract void resisterProduct(Product product);
}
