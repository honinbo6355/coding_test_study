package programmers.solution;

// 풀이1
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class GameMap {
//	class Position {
//		int xPos;
//		int yPos;
//
//		Position(int xPos, int yPos) {
//			this.xPos = xPos;
//			this.yPos = yPos;
//		}
//
//		boolean isEscaped(int mapsWidth, int mapsHeight) {
//			if (xPos < 0 || xPos > mapsWidth-1 || yPos < 0 || yPos > mapsHeight-1) {
//				return true;
//			}
//
//			return false;
//		}
//	}
//	public int solution(int[][] maps) {
//		int mapsWidth = maps[0].length;
//		int mapsHeight = maps.length;
//
//		int[][] count = new int[mapsHeight][mapsWidth];
//		boolean[][] trace = new boolean[mapsHeight][mapsWidth];
//		final int[][] movings = {{0,-1},{1,0},{0,1},{-1,0}};
//
//		Queue<Position> queue = new LinkedList<>();
//
//		queue.add(new Position(0, 0));
//		count[0][0] = 1;
//		trace[0][0] = true;
//
//		while (!queue.isEmpty()) {
//			Position current = queue.poll();
//
//			for (int[] moving : movings) {
//				int movedX = current.xPos + moving[0];
//				int movedY = current.yPos + moving[1];
//
//				Position movedPosition = new Position(movedX, movedY);
//
//				if (movedPosition.isEscaped(mapsWidth, mapsHeight)) {
//					continue;
//				}
//				if (trace[movedY][movedX]) {
//					continue;
//				}
//				if (maps[movedY][movedX] == 0) {
//					continue;
//				}
//				count[movedY][movedX] = count[current.yPos][current.xPos] + 1;
//				trace[movedY][movedX] = true;
//				queue.add(movedPosition);
//			}
//		}
//
//		int answer = count[mapsHeight-1][mapsWidth-1];
//		if (answer == 0) {
//			return -1;
//		}
//
//		return answer;
//	}
//	public static void main(String[] args) {
//		GameMap gameMap = new GameMap();
//
//		int[][] maps = {
//			{1,0,1,1,1},
//			{1,0,1,0,1},
//			{1,0,1,1,1},
//			{1,1,1,0,1},
//			{0,0,0,0,1}
//		};
//
//		System.out.println(gameMap.solution(maps));
//	}
//}

// 풀이2
import java.util.LinkedList;
import java.util.Queue;

public class GameMap {
	public static void main(String[] args) {
		GameMap g = new GameMap();
        System.out.println(g.solution(new int[][] {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        }));
		System.out.println(g.solution(new int[][] {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,0},
				{0,0,0,0,1}
		}));
	}

	public int solution(int[][] maps) {
		// 맵 생성
		// isVisited
		int rowLen = maps.length;
		int columnLen = maps[0].length;
		boolean[][] isVisited = new boolean[rowLen][columnLen];
		Queue<Character> queue = new LinkedList<>();
		int[][] directions = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
		int answer = Integer.MAX_VALUE;

		isVisited[0][0] = true;
		queue.add(new Character(0, 0, 1));

		while (!queue.isEmpty()) {
			Character character = queue.poll();

			if (character.columnIdx == columnLen-1 && character.rowIdx == rowLen-1) {
				answer = Math.min(character.count, answer);
				continue;
			}

			for (int[] direction : directions) {
				int movedColumnIdx = character.columnIdx+direction[1];
				int movedRowIdx = character.rowIdx+direction[0];

				if (movedRowIdx < 0 || movedRowIdx >= rowLen || movedColumnIdx < 0 || movedColumnIdx >= columnLen) {
					continue;
				}

				if (isVisited[movedRowIdx][movedColumnIdx]) {
					continue;
				}

				if (maps[movedRowIdx][movedColumnIdx] == 0) {
					continue;
				}
				queue.add(new Character(movedColumnIdx, movedRowIdx, character.count+1));
				isVisited[movedRowIdx][movedColumnIdx] = true;
			}
		}

		if (!isVisited[rowLen-1][columnLen-1]) {
			return -1;
		}

		return answer;
	}
}

class Character {
	int columnIdx;
	int rowIdx;
	int count;

	Character(int columnIdx, int rowIdx, int count) {
		this.columnIdx = columnIdx;
		this.rowIdx = rowIdx;
		this.count = count;
	}
}
