package pattern.JU.Composite;

import org.springframework.stereotype.Service;

/**
 * Created by cha45 on 2017-05-01.
 */
@Service
public class CompositeService {
    public void printFileTree(Entry entry) {
        entry.printList();
    }
}
