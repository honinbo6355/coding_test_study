package baekjoon.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ApartNumber {
	private static int dx[] = {0,1,0,-1};
	private static int dy[] = {-1,0,1,0};
	private static int map[][] = new int[25][25];
	private static boolean visited[][] = new boolean[25][25];
	private static int apartNum = 0;
	private static List<Integer> apartCount = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		for (int y=0; y<N; y++) {
			String str = sc.nextLine();
			for (int x=0; x<N; x++) {
				map[y][x] = str.charAt(x) - '0';
			}
		}
		
		for (int y=0; y<N; y++) {
			for (int x=0; x<N; x++) {
				if (map[y][x] == 1 && !visited[y][x]) {
					apartNum++; // 총 단지수 증가
					apartCount.add(bfs(N, x, y)); // 현재 단지와 연결되어 있는 단지 수 계산
				}
			}
		}
		
		Collections.sort(apartCount);
		
		System.out.println(apartNum);
		
		for (Integer count : apartCount) {
			System.out.println(count);
		}
	}
	
	private static int bfs(int N, int x, int y) {
		int count = 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y, x});
		visited[y][x] = true;
		
		while (!queue.isEmpty()) {
			int[] position = queue.poll();
			int currentY = position[0];
			int currentX = position[1];
			
			for (int i=0; i<4; i++) {
				int movedY = currentY + dy[i];
				int movedX = currentX + dx[i];
				
				// 가로, 세로가 0 이상 N 미만 && 방문하지 않았고 && map value가 1인 경우
				if (movedY >= 0 && movedX >= 0 && movedY < N && movedX < N && !visited[movedY][movedX] && map[movedY][movedX] == 1) {
					queue.add(new int[] {movedY, movedX});
					visited[movedY][movedX] = true;
					count++;
				}
			}
		}
		
		return count;
	}
}



