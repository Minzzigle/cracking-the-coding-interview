package pattern.JU.Iterator;

/**
 * Created by cha45 on 2017-04-16.
 */
public interface BookShelfInterface extends Aggregate{
    int getLength();
    Object getBookAt(int index);
    void appendBook(Book book);
}
