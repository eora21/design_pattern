package adapter.file_properties;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIo fileIo = new FileProperties();

        try {
            fileIo.readFromFile("file.txt");
            System.out.println(fileIo.getValue("width"));
            System.out.println();

            fileIo.setValue("width", "1024");
            fileIo.setValue("height", "512");
            fileIo.setValue("depth", "32");

            String newFilename = "newfile.txt";
            fileIo.writeToFile(newFilename);
            System.out.println(newFilename + " is created.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
