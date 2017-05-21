package pattern.JU.composite;

import org.junit.Test;

/**
 * Created by cha45 on 2017-05-01.
 */
public class compositeServiceTest {
    @Test
    public void printFileTree() throws Exception {
        // given
        Directory rootdir = new Directory("root");
        Directory bindir = new Directory("bin");
        Directory tempdir = new Directory("temp");
        Directory usrdir = new Directory("usr");
        rootdir.add(bindir);
        rootdir.add(tempdir);
        rootdir.add(usrdir);
        bindir.add(new File("vi", 10000));
        bindir.add(new File("latex", 20000));

        // when
        try {
            rootdir.printList();
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }

        // then
    }

}