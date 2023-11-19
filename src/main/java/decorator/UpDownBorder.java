package decorator;

public class UpDownBorder extends Border {
    private final char borderChar;

    public UpDownBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == display.getRows() + 1) {
            return String.valueOf(borderChar).repeat(display.getColumns());
        }

        return display.getRowText(row - 1);
    }
}
