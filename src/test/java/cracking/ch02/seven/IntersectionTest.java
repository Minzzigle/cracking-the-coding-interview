package cracking.ch02.seven;

import cracking.ch02.LinkedList;
import cracking.ch02.Node;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

public class IntersectionTest {
    private LinkedList l1;
    private LinkedList l2;
    private Node sameNode;

    public Intersection intersection;

    @Before
    public void setUp() {
        intersection = new Intersection();
    }

    @Before
    public void before() {
        Node sameNode = new Node(3);
        LinkedList l1 = new LinkedList();
        l1.appendToTail(2);
        l1.appendToTailNode(sameNode);
        l1.appendToTail(3);
        LinkedList l2 = new LinkedList();
        l2.appendToTail(4);
        l2.appendToTail(5);
        l2.appendToTailNode(sameNode);

        this.l1 = l1;
        this.l2 = l2;
        this.sameNode = sameNode;
    }

    @Test
    public void solve1() {
        // given

        // when
        Node result = intersection.solve1(l1, l2);

        // then
        if(result != sameNode) {
            fail();
        }
    }

    @Test
    public void solve2() {
        // given

        // when
        Node result = intersection.solve2(l1, l2);

        // then
        if(result != sameNode) {
            fail();
        }
    }

    @Test
    public void solve3() {
        // given

        // when
        Node result = intersection.solve3(l1, l2);

        // then
        if(result != sameNode) {
            fail();
        }
    }

}