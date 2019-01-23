package cracking.ch08.two;

import java.util.ArrayList;
import java.util.List;

/**
 * Maze
 *
 * @author jongUn
 * @since 2018. 01. 12.
 */
public class Maze {
	boolean [][] maze;
	boolean [][] alreadyVisited;

	public Maze(boolean[][] maze) {
		this.maze = maze;
		this.alreadyVisited = new boolean[maze.length][maze[0].length];
	}

	public List<Point> getPath() {
		if(maze == null || maze.length == 0) {
			return null;
		}

		List<Point> path = new ArrayList<>();
		if(find(maze.length - 1, maze[0].length - 1, path)) {
			return path;
		}

		return null;
	}

	private boolean find(int row, int col, List<Point> path) {
		if(row < 0 || col < 0 || !maze[row][col]) {
			return false;
		}

		boolean isOrigin = row == 0 && col == 0;

		if(alreadyVisited[row][col]) {
			return false;
		}

		if(isOrigin || find(row - 1, col, path) || find(row, col - 1, path)) {
			alreadyVisited[row][col] = true;
			path.add(new Point(row, col));
			return true;
		}

		return false;
	}

	class Point {
		int row;
		int col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "(" + row + "," + col + ")";
		}
	}
}
