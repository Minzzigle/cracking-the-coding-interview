package cracking.ch04.two;

import cracking.ch04.Node;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BalancedTreeTest {
    @Test
    public void make() throws Exception {
        // given
        int [] input = {1,2,3,4,5,6,7,8};

        // when
        BalancedTree balancedTree = new BalancedTree();
        Node head = balancedTree.make(input);

        // then
        assertThat(head.name, is("4"));
        assertThat(head.children[0].name, is("2"));
        assertThat(head.children[0].children[0].name, is("1"));
        assertThat(head.children[0].children[1].name, is("3"));

        assertThat(head.children[1].name, is("6"));
        assertThat(head.children[1].children[0].name, is("5"));
        assertThat(head.children[1].children[1].name, is("7"));

        assertThat(head.children[1].children[1].children[1].name, is("8"));
    }

}