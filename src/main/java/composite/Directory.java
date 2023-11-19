package composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private final List<Entry> directory = new ArrayList<>();
    private final String name;

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return directory.stream()
                .mapToInt(Entry::getSize)
                .sum();
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + super.getDescription());

        for (Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        };
    }

    public void add(Entry entry) {
        directory.add(entry);
        entry.updateParent(this);
    }
}
