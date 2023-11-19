package decorator;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    private final List<String> lines = new ArrayList<>();

    public void add(String line) {
        lines.add(line);
    }

    @Override
    public int getRows() {
        return lines.size();
    }

    @Override
    public int getColumns() {
        return lines.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    @Override
    public String getRowText(int row) {
        String line = lines.get(row);
        return String.format("%s%s", line, " ".repeat(getColumns() - line.length()));
    }
}
