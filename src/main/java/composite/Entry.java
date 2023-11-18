package composite;

public abstract class Entry {
    public abstract String getName();

    public abstract int getSize();

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    public String getDescription() {
        return getName() + " (" + getSize() + ")";
    }
}
