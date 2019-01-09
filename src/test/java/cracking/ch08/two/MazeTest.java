package cracking.ch08.two;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * MazeTest
 *
 * @author jongUn
 * @since 2018. 01. 12.
 */
public class MazeTest {
	private Maze maze = new Maze();

	@Test
	public void find() {
		// given
		maze.maxX = 2;
		maze.maxY = 2;
		maze.blocks = makeBlocks();

		// when
		maze.find(0, 0, "");

		// then

	}

	private boolean [][] makeBlocks() {
		boolean [] a = {true, true, false};
		boolean [] b = {true, true, true};
		boolean [] c = {true, true, true};
		boolean [][] blocks = new boolean[3][3];
		blocks[0] = a;
		blocks[1] = b;
		blocks[2] = c;

		return blocks;
	}

}