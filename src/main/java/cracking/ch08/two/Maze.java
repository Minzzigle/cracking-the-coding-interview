package cracking.ch08.two;

import java.util.List;

/**
 * Maze
 *
 * @author jongUn
 * @since 2018. 01. 12.
 */
public class Maze {
	public boolean [][] blocks;
	public int maxX;
	public int maxY;

	public void find(int nowX, int nowY, String result) {
		if(nowX == maxX && nowY == maxY) {
			result += makeFormat(nowX, nowY);
			System.out.println(result);
			return;
		}

		boolean right = nowY < maxY ? blocks[nowX][nowY + 1] : false;
		boolean down = nowX < maxX ? blocks[nowX + 1][nowY] : false;

		String nowPos = makeFormat(nowX, nowY);
		if(right) {
			find(nowX, nowY + 1, new String(result) + nowPos);
		}

		if(down) {
			find(nowX +1, nowY, new String(result) + nowPos);
		}
	}

	private String makeFormat(int r, int c) {
		return "(" + String.valueOf(r) +"," + String.valueOf(c) + ")";
	}
}
