package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book> {
    private final List<Book> books;

    public BookShelf(int initSize) {
        this.books = new ArrayList<>(initSize);
    }

    public int getNowSize() {
        return books.size();
    }

    public void add(Book book) {
        books.add(book);
    }

    public Book getBook(int i) {
        return books.get(i);
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
