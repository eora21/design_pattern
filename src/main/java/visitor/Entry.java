package visitor;

public abstract class Entry implements Element {
    public abstract String getName();

    public abstract int getSize();

    public String getDescription() {
        return String.format("%s (%,d)",getName(), getSize());
    }
}
