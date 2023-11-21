package proxy;

import java.util.Objects;

public class PrinterProxy implements Printable {
    private String name;
    private Printer real;

    public PrinterProxy() {
        this.name = "No Name";
    }

    public PrinterProxy(String name) {
        this.name = name;
    }

    @Override
    public void setPrinterName(String name) {
        if (Objects.nonNull(real)) {
            real.setPrinterName(name);
        }

        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String text) {
        realize();
        real.print(text);
    }

    private synchronized void realize() {
        if (Objects.isNull(real)) {
            real = new Printer(name);
        }
    }
}
