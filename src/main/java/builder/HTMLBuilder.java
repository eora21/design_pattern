package builder;

public class HTMLBuilder extends Builder {
    private final StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        stringBuilder.append("H1 ")
                .append(title)
                .append("\n");
    }

    @Override
    public void makeString(String str) {
        stringBuilder.append("p ")
                .append(str)
                .append("\n");
    }

    @Override
    public void makeItems(String... items) {
        stringBuilder.append("ul\n");

        for (String item : items) {
            stringBuilder.append("li ")
                    .append(item)
                    .append("\n");
        }

        stringBuilder.append("\n");
    }

    @Override
    public String close() {
        return stringBuilder.toString();
    }
}
