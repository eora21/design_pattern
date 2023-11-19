package facade.pagemaker;

import java.io.IOException;

public class MessageWriter {

    public MessageWriter() {
    }

    public void title(String title) throws IOException {
        System.out.println("제목");
        System.out.println(title);
    }

    public void paragraph(String message) throws IOException {
        System.out.println("단락");
        System.out.println(message);
    }

    public void link(String href, String caption) throws IOException {
        System.out.println("링크");
        System.out.println(caption + ": " + href);
    }
}
