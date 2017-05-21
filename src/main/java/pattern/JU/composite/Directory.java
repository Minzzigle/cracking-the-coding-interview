package pattern.JU.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cha45 on 2017-05-01.
 */
public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getSize() {
        return directory.stream().mapToInt(Entry::getSize).sum();
    }

    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        directory.stream().forEach(entry -> entry.printList(prefix + "/" + name));
    }
}
