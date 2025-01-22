package iterator;

import java.util.ArrayList;
import java.util.List;

public class Library implements Aggregate {
    List<Book> books = new ArrayList<Book>();
    public Library(List<Book> books) {
        this.books = books;
    }

    @Override
    public Iterator createIterator() {
        return new BookIteratoor(books);
    }
}
