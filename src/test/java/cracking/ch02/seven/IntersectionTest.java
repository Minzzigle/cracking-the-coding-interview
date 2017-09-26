package cracking.ch02.seven;

import cracking.ch02.LinkedList;
import cracking.ch02.Node;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class IntersectionTest {
    @InjectMocks
    public Intersection intersection;

    @Test
    public void solve1() throws Exception {
        // given
        Node sameNode = new Node(3);
        LinkedList l1 = new LinkedList();
        l1.appendToTail(2);
        l1.appendToTailNode(sameNode);
        l1.appendToTail(3);
        LinkedList l2 = new LinkedList();
        l2.appendToTail(4);
        l2.appendToTail(5);
        l2.appendToTailNode(sameNode);

        // when
        Node result = intersection.solve1(l1, l2);

        // then
        if(result != sameNode) {
            fail();
        }
    }

}