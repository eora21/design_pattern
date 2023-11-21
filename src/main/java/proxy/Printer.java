package proxy;

public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("Printer 인스턴스 생성 중");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("Printer 인스턴스 생성 중");
    }

    private void heavyJob(String text) {
        System.out.print(text);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("완료");
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String text) {
        System.out.println("=== " + name + " ===");
        System.out.println(text);
    }
}
