package proxy;

public class Main {
    public static void main(String[] args) {
        PrinterProxy printerProxy = new PrinterProxy("Alice");
        System.out.println("이름은 현재 " + printerProxy.getPrinterName() + "입니다.");

        printerProxy.setPrinterName("Bob");
        System.out.println("이름은 현재 " + printerProxy.getPrinterName() + "입니다.");
        printerProxy.print("Hello, world");
    }
}
