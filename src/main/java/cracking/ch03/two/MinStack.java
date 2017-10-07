package cracking.ch03.two;

import cracking.ch03.Stack;

public class MinStack extends Stack<Integer> {
    private Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }

    public Integer min() {
        if (this.minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        return minStack.peek();
    }

    @Override
    public void push(Integer item) {
        if (item <= min()) {
            minStack.push(item);
        }

        super.push(item);
    }

    @Override
    public Integer pop() {
        int value = super.pop();
        if(value == min()) {
            minStack.pop();
        }

        return value;
    }
}
