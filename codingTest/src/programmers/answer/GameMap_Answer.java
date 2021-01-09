package programmers.answer;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap_Answer {
	class Position {
		int x, y;
		
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		boolean isValid(int width, int height) {
			if (x < 0 || x >= width) return false;
			if (y < 0 || y >= height) return false;
			return true;
		}
	}
	
	public int solution(int[][] maps) {
		// BFS : Queue
		
		int mapHeight = maps.length;
		int mapWidth = maps[0].length;
		Queue<Position> queue = new LinkedList<>();
		int[][] count = new int[mapHeight][mapWidth]; // 최단거리를 구하기 위한 변수
		boolean[][] visited = new boolean[mapHeight][mapWidth]; // 지나온 길인지 아닌지 확인을 위한 변수
		
		queue.offer(new Position(0, 0));
		count[0][0] = 1;  
		visited[0][0] = true;
		
        // queue에 데이터가 존재할때까지 반복한다.
        // 먼저 도착하는 쪽이 visited를 true로 바꿔놓았기 때문에 queue는 결국 비어질 수 밖에 없다.
		while (!queue.isEmpty()) {
			Position current = queue.poll();
			
			int currentCount = count[current.y][current.x]; 
			
			//4가지 경우(동,서,남,북)
			final int[][] moving = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
			for (int i=0; i<moving.length; i++) {
				Position moved = new Position(current.x + moving[i][0], current.y + moving[i][1]);
				if (!moved.isValid(mapWidth, mapHeight)) continue;
				if (visited[moved.y][moved.x]) continue;
				if (maps[moved.y][moved.x] == 0) continue; // 0: 벽, 1: 길
				
				// 방문하지 않은 위치 && 벽이 아닌 경우 && x축 범위를 넘어서지 않은 경우, y축 범위를 넘어서지 않은 경우
				count[moved.y][moved.x] = currentCount + 1;
				visited[moved.y][moved.x] = true;
				queue.offer(moved);
			}
		}
		
		int answer = count[mapHeight-1][mapWidth-1];
		if (answer == 0) return -1;
		
		return answer;
	}
	
	public static void main(String[] args) {
		GameMap_Answer gameMap_Answer = new GameMap_Answer();
		
		int[][] maps = {
			{1,0,1,1,1},
			{1,0,1,0,1},
			{1,0,1,1,1},
			{1,1,1,0,1},
			{0,0,0,0,1}	
		};
		
		System.out.println(gameMap_Answer.solution(maps));
	}
}
