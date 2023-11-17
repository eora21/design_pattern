package iterator;

import java.util.Iterator;

public class BookShelfIterator implements Iterator<Book> {
    private final BookShelf bookShelf;
    private int nowIndex = 0;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public boolean hasNext() {
        return nowIndex < bookShelf.getNowSize();
    }

    @Override
    public Book next() {
        return bookShelf.getBook(nowIndex++);
    }
}
