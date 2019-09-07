package cracking.pre;

import static org.junit.Assert.assertTrue;

public class SortAssertionUtils {

    public static void assertIsSorted(int[] arr) {
        Integer pre = null;
        for(int each : arr) {
            if(pre == null) {
                pre = each;
            } else {
                assertTrue(pre <= each);
                pre = each;
            }

        }
    }
}
