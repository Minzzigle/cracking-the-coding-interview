package cracking.ch08.two;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * MazeTest
 *
 * @author jongUn
 * @since 2018. 01. 12.
 */
public class MazeTest {

	private Maze maze;

	@Before
	public void setUp() {
		maze = new Maze(makeBlocks());
	}

	@Test
	public void find() {
		// given

		// when
		List<Maze.Point> result = maze.getPath();

		// then
		for(Maze.Point each : result) {
			System.out.print(each);
		}
		System.out.println();

	}

	private boolean [][] makeBlocks() {
		boolean [] a = {true, true, true};
		boolean [] b = {false, false, true};
		boolean [] c = {false, false, true};
		boolean [][] blocks = new boolean[3][3];
		blocks[0] = a;
		blocks[1] = b;
		blocks[2] = c;

		return blocks;
	}

}