package flyweight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    private static final String PATH = "src/main/java/flyweight/file/";
    private final String fontData;

    public BigChar(char charName) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            String fileName = PATH + "big" + charName + ".txt";
            Files.readAllLines(Path.of(fileName))
                    .forEach(line -> stringBuilder.append(line).append("\n"));
        } catch (IOException e) {
            stringBuilder.append(charName)
                    .append("?");
        }

        this.fontData = stringBuilder.toString();
    }

    public void print() {
        System.out.println(fontData);
    }
}
