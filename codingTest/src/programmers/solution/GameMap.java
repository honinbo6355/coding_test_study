package programmers.solution;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap {
	class Position {
		int xPos;
		int yPos;
		
		Position(int xPos, int yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
		}
		
		boolean isEscaped(int mapsWidth, int mapsHeight) {
			if (xPos < 0 || xPos > mapsWidth-1 || yPos < 0 || yPos > mapsHeight-1) {
				return true;
			}
			
			return false;
		}
	}
	public int solution(int[][] maps) {
		int mapsWidth = maps[0].length;
		int mapsHeight = maps.length;
		
		int[][] count = new int[mapsHeight][mapsWidth];
		boolean[][] trace = new boolean[mapsHeight][mapsWidth];
		final int[][] movings = {{0,-1},{1,0},{0,1},{-1,0}};
		
		Queue<Position> queue = new LinkedList<>();
		
		queue.add(new Position(0, 0));
		count[0][0] = 1;
		trace[0][0] = true;
		
		while (!queue.isEmpty()) {
			Position current = queue.poll();
			
			for (int[] moving : movings) {
				int movedX = current.xPos + moving[0];
				int movedY = current.yPos + moving[1];
				
				Position movedPosition = new Position(movedX, movedY);
				
				if (movedPosition.isEscaped(mapsWidth, mapsHeight)) {
					continue;
				}
				if (trace[movedY][movedX]) {
					continue;
				}
				if (maps[movedY][movedX] == 0) {
					continue;
				}
				count[movedY][movedX] = count[current.yPos][current.xPos] + 1;
				trace[movedY][movedX] = true;
				queue.add(movedPosition);
			}
		}
		
		int answer = count[mapsHeight-1][mapsWidth-1];
		if (answer == 0) {
			return -1;
		}
		
		return answer;
	}
	public static void main(String[] args) {
		GameMap gameMap = new GameMap();
		
		int[][] maps = {
			{1,0,1,1,1},
			{1,0,1,0,1},
			{1,0,1,1,1},
			{1,1,1,0,1},
			{0,0,0,0,1}	
		};
		
		System.out.println(gameMap.solution(maps));
	}
}
