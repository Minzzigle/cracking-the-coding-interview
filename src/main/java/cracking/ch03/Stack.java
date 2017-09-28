package cracking.ch03;

import java.util.EmptyStackException;

/**
 * Stack
 * 스택은 LIFO에 따라 자료를 배열한다.
 * 다음과 같은 연산이 존재한다.
 * pop : 스택에서 가장 위에 있는 항목을 제거한다
 * push(item) : item 하나를 스택의 가장 윗부분에 추가한다.
 * peek : 스택의 가장 위에 있는 항목을 반환한다
 * isEmpty : 스택이 비어 있을때 true를 반환한다.
 *
 * @author jongUn
 * @since 2017. 09. 28.
 */
public class Stack<T> {
	private StackNode top;
	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}

		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T item) {
		StackNode t = new StackNode(item);
		t.next = top;
		top = t;
	}

	public T peek() {
		if (top == null) {
			throw new EmptyStackException();
		}

		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}


	private class StackNode {
		private T data;
		private StackNode next;
		public StackNode(T input) {
			this.data = input;
		}
	}


}
