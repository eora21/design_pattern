package adapter.file_properties;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FileProperties implements FileIo {
    private static final String PATH = "src/main/java/adapter/file_properties/file/";
    private final Properties properties;

    public FileProperties() {
        this.properties = new Properties();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        properties.load(new BufferedReader(new FileReader(PATH + filename)));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        properties.store(new BufferedWriter(new FileWriter(PATH + filename, false)),
                "written by FileProperties");
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
