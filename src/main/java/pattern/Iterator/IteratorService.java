package pattern.Iterator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cha45 on 2017-04-09.
 */
@Service
public class IteratorService {
    public List<String> findAllBookName(BookShelf bookShelf) {
        Iterator iterator = bookShelf.iterator();
        List<String> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Book book = (Book)iterator.next();
            result.add(book.getName());
        }

        return result;
    }
}
