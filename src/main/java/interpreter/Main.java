package interpreter;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            for (String text : Files.readAllLines(Path.of("src/main/java/interpreter/program.txt"))) {
                System.out.println("text = \"" + text + "\"");
                Node programNode = new ProgramNode();
                programNode.parse(new Context(text));
                System.out.println("node = " + programNode.getDescription());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
