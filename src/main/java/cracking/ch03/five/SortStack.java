package cracking.ch03.five;

import cracking.ch03.Stack;

public class SortStack {
    public Stack<Integer> sort(Stack<Integer> input) {
        if(input.isEmpty()) {
            return new Stack<>();
        }

        Stack<Integer> result = new Stack<>();

        while(!input.isEmpty()) {
            Integer maxValue = getMaxValue(input, result);
            setInput(input, maxValue, result);
        }

        return result;
    }

    private void setInput(Stack<Integer> input, int maxValue, Stack<Integer> result) {
        boolean isTransfer = false;

        while(!result.isEmpty()) {
            Integer item = result.pop();
            if(item == maxValue && !isTransfer) {
                isTransfer = true;
                continue;
            } else if(maxValue <= item) {
                result.push(item);
                result.push(maxValue);
                return;
            } else {
                input.push(item);
            }
        }

        result.push(maxValue);
    }

    private int getMaxValue(Stack<Integer> input, Stack<Integer> output) {
        int maxValue = Integer.MIN_VALUE;

        while(!input.isEmpty()) {
            Integer item = input.pop();
            if(item > maxValue) {
                maxValue = item;
            }

            output.push(item);
        }
        return maxValue;
    }
}
