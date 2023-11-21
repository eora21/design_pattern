package proxy;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class PrinterProxy implements Printable {
    private static final String PATH = "proxy.";
    private final String className;
    private String name;
    private Printable real;

    public PrinterProxy(String className) {
        this.className = className;
        this.name = "No Name";
    }

    public PrinterProxy(String className, String name) {
        this.className = className;
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
        if (Objects.nonNull(real)) {
            return;
        }

        try {
            real = (Printable) Class.forName(PATH + className)
                    .getDeclaredConstructor()
                    .newInstance();

            real.setPrinterName(name);

        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
