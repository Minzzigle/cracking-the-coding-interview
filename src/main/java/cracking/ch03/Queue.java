package cracking.ch03;

import java.util.NoSuchElementException;

/**
 * Queue
 * add(item) : item을 리스트의 끝부분에 추가한다.
 * remove() : 리스트의 첫 번째 항목을 제거한다.
 * peek() : 큐에서 가장 위에 있는 항목을 반환한다.
 * isEmpty() : 큐가 비어 있을때 true 를 반환한다.
 *
 * @author jongUn
 * @since 2017. 09. 28.
 */
public class Queue<T> {
	private QueueNode first;
	private QueueNode last;

	public void add(T item) {
		QueueNode t = new QueueNode(item);
		if (last != null) {
			last.next = t;
		}
		last = t;
		if (first == null) {
			first = last;
		}
	}

	public T remove() {
		if (first == null) {
			throw new NoSuchElementException();
		}

		T data = first.data;
		first = first.next;

		if(first == null) {
			last = null;
		}

		return data;
	}

	public T peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}

		return first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}

	private class QueueNode {
		private T data;
		private QueueNode next;

		public QueueNode(T data) {
			this.data = data;
		}
	}
}
