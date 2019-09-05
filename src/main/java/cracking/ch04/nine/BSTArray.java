package cracking.ch04.nine;

import cracking.ch04.Node;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * P185 4.9
 * hint : #39, #48, #66, #82
 */
public class BSTArray {
    public ArrayList<LinkedList<Integer>> solve(Node node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if(node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.value);

        ArrayList<LinkedList<Integer>> left = solve(node.children[0]);
        ArrayList<LinkedList<Integer>> right = solve(node.children[1]);

        for(LinkedList<Integer> leftLinked : left) {
            for(LinkedList<Integer> rightLinked : right) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(leftLinked, rightLinked, weaved, prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    public void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if(first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        Integer firstTarget = first.remove();
        prefix.addLast(firstTarget);
        weaveLists(first, second, results, prefix);

        // 재귀호출이 끝난 후 원소를 돌려 놓는다.
        first.addFirst(prefix.removeLast());

        Integer secondTarget = second.remove();
        prefix.addLast(secondTarget);
        weaveLists(first, second, results, prefix);

        // 재귀호출이 끝난 후 원소를 돌려 놓는다.
        second.addFirst(prefix.removeLast());
    }
}
