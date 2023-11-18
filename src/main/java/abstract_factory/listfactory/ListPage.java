package abstract_factory.listfactory;

import abstract_factory.factory.Item;
import abstract_factory.factory.Page;
import java.util.StringJoiner;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(title);

        for (Item item : content) {
            stringJoiner.add(item.makeHTML());
        }

        stringJoiner.add(author);

        return stringJoiner.toString();
    }
}
