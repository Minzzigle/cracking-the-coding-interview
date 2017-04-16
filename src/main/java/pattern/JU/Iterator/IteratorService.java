package pattern.JU.Iterator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cha45 on 2017-04-09.
 */
@Service
public class IteratorService {
    public List<String> findAllBookName(Aggregate bookShelf) {
        Iterator iterator = bookShelf.iterator();
        return generateBookNameList(iterator);
    }

    private List<String> generateBookNameList(Iterator iterator) {
        List<String> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Book book = (Book)iterator.next();
            result.add(book.getName());
        }

        return result;
    }
}
