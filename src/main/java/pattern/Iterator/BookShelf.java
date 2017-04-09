package pattern.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cha45 on 2017-04-09.
 */
public class BookShelf implements Aggregate{
    List<Book> books = new ArrayList<>();
    private int last = 0;

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
        last++;
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
