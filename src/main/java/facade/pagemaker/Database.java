package facade.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private static final String PATH = "src/main/java/facade/pagemaker/";
    private Database() {
    }

    public static Properties getProperties(String dbname) throws IOException {
        String filename = PATH + dbname + ".txt";
        Properties properties = new Properties();
        properties.load(new FileReader(filename));
        return properties;
    }
}
