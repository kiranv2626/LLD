package iterator;

import java.util.List;

public class BookIteratoor implements Iterator {
    List<Book> books;
    int index;

    public BookIteratoor(List<Book> books) {
        this.books = books;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < books.size();
    }

    @Override
    public Book next() {
        return books.get(index++);
    }
}
