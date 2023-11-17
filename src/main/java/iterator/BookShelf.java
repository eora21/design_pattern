package iterator;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
    private final Book[] books;
    private int nowSize = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public int getNowSize() {
        return nowSize;
    }

    public void add(Book book) {
        books[nowSize] = book;
        nowSize++;
    }

    public Book getBook(int i) {
        return books[i];
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
