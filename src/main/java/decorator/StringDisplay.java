package decorator;

public class StringDisplay extends Display {
    private final String line;

    public StringDisplay(String line) {
        this.line = line;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public int getColumns() {
        return line.length();
    }

    @Override
    public String getRowText(int row) {
        if (row != 0) {
            throw new IndexOutOfBoundsException();
        }

        return line;
    }
}
