package baekjoon.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchCity {
	public static int[] distance = new int[300001]; // 모든 도시에 대한 최단 거리 초기화
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void bfs(int X, int K) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(X);
		distance[X] = 0; // 출발 도시까지의 거리는 0으로 설정
		
		while (!q.isEmpty()) {
			int current = q.poll();
			
			// 현재 도시에서 이동할 수 있는 모든 도시를 확인
			for (int i=0; i<graph.get(current).size(); i++) {
				int adjacent = graph.get(current).get(i);
				
				// 아직 방문하지 않은 도시라면
				if (distance[adjacent] == -1) {
					distance[adjacent] = distance[current] + 1; // 최단 거리 갱신
					q.offer(adjacent);
				}
			}
		}
		
		boolean result = false;
		
		// 최단 거리가 K인 모든 도시의 번호를 오름차순으로 출력
		for (int i=0; i<distance.length; i++) {
			if (distance[i] == K) {
				System.out.println(i);
				result = true;
			}
		}
		
		// 만약 최단 거리가 K인 도시가 없다면, -1 출력
		if (!result) {
			System.out.println(-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 도시의 개수, 도로의 개수, 거리 정보, 출발 도시 번호
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int X = sc.nextInt();
		
		// 그래프 및 최단 거리 테이블 초기화
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
			distance[i] = -1;
		}
		
		// 모든 도로 정보 입력 받기
		for (int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			graph.get(from).add(to);
		}
		
		bfs(X, K);
	}
}
