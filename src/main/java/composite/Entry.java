package composite;

import java.util.Objects;

public abstract class Entry {
    private Entry parent;

    protected void updateParent(Entry parent) {
        this.parent = parent;
    }

    public abstract String getName();

    public abstract int getSize();

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    public String getDescription() {
        return getName() + " (" + getSize() + ")";
    }

    public void printPath() {
        System.out.println(getPath(new StringBuilder()).toString());
    }

    protected StringBuilder getPath(StringBuilder stringBuilder) {
        if (Objects.nonNull(parent)) {
            parent.getPath(stringBuilder);
        }

        return stringBuilder.append("/")
                .append(getName());
    }
}
