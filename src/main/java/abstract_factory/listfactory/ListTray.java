package abstract_factory.listfactory;

import abstract_factory.factory.Item;
import abstract_factory.factory.Tray;
import java.util.StringJoiner;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(caption)
                .add("하위 목록");

        for (Item item : tray) {
            stringJoiner.add(item.makeHTML());
        }

        return stringJoiner.toString();
    }
}
