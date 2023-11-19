package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {
    }

    public static void makeWelcomePage(String mailAddress, String filename) {
        try {
            Properties mailProperties = Database.getProperties("maildata");
            String username = mailProperties.getProperty(mailAddress);
            MessageWriter writer = new MessageWriter();
            writer.title(username + "'s message");
            writer.paragraph("Nice 2 meet u");
            writer.link("http link", "링크에요");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
