package abstract_factory;

import abstract_factory.factory.Factory;
import abstract_factory.factory.Link;
import abstract_factory.factory.Page;
import abstract_factory.factory.Tray;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("파일명과 팩토리명을 명시해주세요.");
            return;
        }

        String filename = args[0];
        String classname = args[1];

        Factory factory = Factory.getFactory(classname);

        Link firstBlog = factory.createLink("firstBlog", "https://example.com/blog1");
        Link secondBlog = factory.createLink("secondBlog", "https://example.com/blog1");
        Link thirdBlog = factory.createLink("thirdBlog", "https://example.com/blog1");

        Tray blogTray = factory.createTray("Blog site");
        blogTray.add(firstBlog);
        blogTray.add(secondBlog);
        blogTray.add(thirdBlog);

        Link firstNews = factory.createLink("firstNews", "https://example.com/news1");
        Link secondNews = factory.createLink("secondNews", "https://example.com/news1");
        Tray thirdNews = factory.createTray("thirdNews");
        thirdNews.add(factory.createLink("thirdNews(US)", "https://example.com/news3us"));
        thirdNews.add(factory.createLink("thirdNews(KOREA)", "https://example.com/news3kr"));

        Tray newsTray = factory.createTray("News site");
        newsTray.add(firstNews);
        newsTray.add(secondNews);
        newsTray.add(thirdNews);

        Page page = factory.createPage("Blog and News", "Younjin.com");
        page.add(blogTray);
        page.add(newsTray);

        page.output(filename);
    }
}
