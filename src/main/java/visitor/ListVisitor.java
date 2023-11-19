package visitor;

import java.util.ArrayDeque;
import java.util.Deque;

public class ListVisitor extends Visitor {
    private final Deque<String> dirQueue = new ArrayDeque<>();

    @Override
    public void visit(File file) {
        System.out.println(getCurrentDir() + "/" + file.getDescription());
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(getCurrentDir() + "/" + directory.getDescription());
        dirQueue.add("/" + directory.getName());

        for (Entry entry : directory) {
            entry.accept(this);
        }

        dirQueue.removeLast();
    }

    private String getCurrentDir() {
        StringBuilder stringBuilder = new StringBuilder();
        dirQueue.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
