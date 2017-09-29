package cracking.ch03.three;

import cracking.ch03.Stack;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * SetOfStacks
 *
 * @author jongUn
 * @since 2017. 09. 29.
 */
public class SetOfStacks<T> {
	private static final int UPPER_SIZE = 2;
	private LinkedList<Stack> linkedList = new LinkedList<>();
	private Stack<T> topStack;

	public void push(T item) {
		if(linkedList.isEmpty()) {
			Stack stack = addStack(item);
			topStack = stack;
			return;
		}

		try {
			topStack.push(item);
		} catch (RuntimeException ex) {
			Stack stack = addStack(item);

			topStack = stack;
		}
	}

	private Stack addStack(T item) {
		Stack stack = new Stack(UPPER_SIZE);
		stack.push(item);
		linkedList.push(stack);
		return stack;
	}

	public T pop() {
		if (topStack == null) {
			throw new EmptyStackException();
		}

		T item = topStack.pop();
		if(topStack.isEmpty()) {
			linkedList.removeFirst();
			if(linkedList.isEmpty()) {
				topStack = null;
			} else {
				topStack = linkedList.peekFirst();
			}
		}

		return item;
	}

	public T popAt(int index) {
		Stack<T> stack = linkedList.get(index);
		return stack.pop();
	}

	public T peek() {
		if(topStack == null) {
			throw new NoSuchElementException();
		}

		return topStack.peek();
	}

	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	private class StackNode {
		private T data;
		private StackNode next;
		public StackNode(T input) {
			this.data = input;
		}
	}
}
