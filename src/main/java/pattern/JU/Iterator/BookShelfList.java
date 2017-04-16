package pattern.JU.Iterator;

import java.util.LinkedList;

/**
 * Created by cha45 on 2017-04-16.
 * 링크드 리스트를 이용하여 구현한 BookShelfList.
 */
public class BookShelfList implements BookShelfInterface {
    LinkedList<Book> bookShelf = new LinkedList<>();

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    @Override
    public int getLength() {
        return bookShelf.size();
    }

    @Override
    public Object getBookAt(int index) {
        return bookShelf.get(index);
    }

    @Override
    public void appendBook(Book book) {
        this.bookShelf.add(book);
    }
}
