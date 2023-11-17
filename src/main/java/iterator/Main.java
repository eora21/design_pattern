package iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.add(new Book("첫번째 책"));
        bookShelf.add(new Book("두번째 책"));
        bookShelf.add(new Book("세번째 책"));
        bookShelf.add(new Book("네번째 책"));
        bookShelf.add(new Book("다섯번째 책"));

        Iterator<Book> iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book nextBook = iterator.next();
            System.out.println(nextBook.getName());
        }

        System.out.println();

        for (Book book : bookShelf) {
            System.out.println(book.getName());
        }
    }
}
