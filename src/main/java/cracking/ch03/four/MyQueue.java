package cracking.ch03.four;

import cracking.ch03.Stack;

/**
 * MyQueue
 *
 * @author jongUn
 * @since 2017. 09. 29.
 */
public class MyQueue<T> {
	Stack<T> inputStack = new Stack<>();
	Stack<T> outputstack = new Stack<>();


	public void add(T item) {
		inputStack.push(item);
	}

	public T remove() {
		if(!outputstack.isEmpty()) {
			return outputstack.pop();
		}

		while(!inputStack.isEmpty()) {
			T item = inputStack.pop();
			outputstack.push(item);
		}

		return outputstack.pop();
	}

	public T peek() {
		if(!outputstack.isEmpty()) {
			return outputstack.peek();
		}

		while(!inputStack.isEmpty()) {
			T item = inputStack.pop();
			outputstack.push(item);
		}

		return outputstack.peek();
	}

	public boolean isEmpty() {
		return inputStack.isEmpty() && outputstack.isEmpty();
	}
}
