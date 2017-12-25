package cracking.ch04.eleven;

import java.util.Random;

/**
 * RandomTreeNode
 *
 * @author jongUn
 * @since 2017. 12. 01.
 */
public class RandomTreeNode {
	int size = 0;
	public RandomTreeNode rightChild = null;
	public RandomTreeNode leftChild = null;
	public Integer data;

	public RandomTreeNode(int data, int size) {
		this.data = data;
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public Integer getData() {
		return data;
	}

	public RandomTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(RandomTreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public RandomTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(RandomTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public RandomTreeNode getRandomNode() {
		int leftSize = leftChild == null ? 0 : leftChild.getSize();
		Random random = new Random();
		int index = random.nextInt(size);

		if(index < size) {
			return leftChild.getRandomNode();
		} else if(index == size) {
			return this;
		} else {
			return rightChild.getRandomNode();
		}
	}

	public void insertRandomNode(int d) {
		if(d < data) {
			if(leftChild == null) {
				leftChild = new RandomTreeNode(d, 0);
			} else {
				leftChild.insertRandomNode(d);
			}
		} else {
			if(rightChild == null) {
				rightChild = new RandomTreeNode(d, 0);
			} else {
				rightChild.insertRandomNode(d);
			}
		}

		size++;
	}

	public RandomTreeNode find(int d) {
		if(d < data) {
			return leftChild != null ? leftChild.find(d) : null;
		} else if (d == data) {
			return this;
		} else if(d > data){
			return rightChild != null ? rightChild.find(d) : null;
		}

		return null;
	}
 }
