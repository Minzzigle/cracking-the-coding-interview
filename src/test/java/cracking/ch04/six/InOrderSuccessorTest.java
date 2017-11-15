package cracking.ch04.six;

import cracking.ch04.TreeNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * InOrderSuccessorTest
 *
 * @author jongUn
 * @since 2017. 11. 12.
 */
public class InOrderSuccessorTest {
	private InOrderSuccessor inOrderSuccessor = new InOrderSuccessor();
	private TreeNode target = null;

	@Test
	public void find() throws Exception {
		// given
		TreeNode input = makeTree(false);

		// when
		TreeNode result = inOrderSuccessor.find(input);

		// then
		assertThat(result, is(this.target));
	}

	@Test
	public void find_hasRightChild() throws Exception {
		// given
		TreeNode input = makeTree(true);

		// when
		TreeNode result = inOrderSuccessor.find(input);

		// then
		assertThat(result, is(this.target));
	}

	private TreeNode makeTree(boolean rightChild)	{
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(7);

		treeNode4.leftChild = treeNode3;
		treeNode4.rightChild = treeNode6;

		treeNode3.leftChild = treeNode1;
		treeNode3.rightChild = treeNode2;

		treeNode6.leftChild = treeNode5;
		treeNode6.rightChild = treeNode7;

		treeNode3.parent = treeNode4;
		treeNode6.parent = treeNode4;

		treeNode1.parent = treeNode3;
		treeNode2.parent = treeNode3;

		treeNode5.parent = treeNode6;
		treeNode7.parent = treeNode6;

		if(rightChild) {
			this.target = treeNode7;
			return treeNode6;
		}

		this.target = treeNode6;
		return treeNode5;
	}

}