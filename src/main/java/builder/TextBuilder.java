package builder;

public class TextBuilder implements Builder {
    private final StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        stringBuilder.append("[")
                .append(title)
                .append("]\n\n");
    }

    @Override
    public void makeString(String str) {
        stringBuilder.append("* ")
                .append(str)
                .append("\n\n");
    }

    @Override
    public void makeItems(String... items) {
        for (String item : items) {
            stringBuilder.append("- ")
                    .append(item)
                    .append("\n");
        }
        stringBuilder.append("\n");
    }

    @Override
    public String close() {
        return stringBuilder.append("===============")
                .toString();
    }
}
