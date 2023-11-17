package prototype.framework;

public abstract class Product implements Cloneable {
    public abstract void use(String s);

    public Product createCopy() {
        try {
            return (Product) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
