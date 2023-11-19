package visitor;

public class Main {
    public static void main(String[] args) {
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory userDir = new Directory("user");

        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(userDir);

        binDir.add(new File("vi", 10_000));
        binDir.add(new File("latex", 20_000));

        ListVisitor visitor = new ListVisitor();
        rootDir.accept(visitor);

        System.out.println();

        Directory youngjin = new Directory("youngjin");
        Directory gildong = new Directory("gildong");
        Directory dojun = new Directory("dojun");

        userDir.add(youngjin);
        userDir.add(gildong);
        userDir.add(dojun);

        youngjin.add(new File("diary.html", 100));
        youngjin.add(new File("Composite.java", 200));

        gildong.add(new File("memo.text", 300));

        dojun.add(new File("game.doc", 400));
        dojun.add(new File("junk.mail", 500));
        rootDir.accept(visitor);
    }
}
