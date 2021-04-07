package baekjoon.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus {
	public static boolean[] visited = new boolean[101];
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	public static void bfs(int start) {
		int totalCnt = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int element = queue.poll();
			
			for (int i=0; i<list.get(element).size(); i++) {
				int adjacent = list.get(element).get(i);
				
				if (!visited[adjacent]) {
					totalCnt++;
					queue.add(adjacent);
					visited[adjacent] = true;
				}
			}
		}
		
		System.out.println(totalCnt);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int computerCnt = sc.nextInt();
		int connectCnt = sc.nextInt();
		
		for (int i=0; i<computerCnt+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i=0; i<connectCnt; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			// 방향이 없는 그래프에서 간선은 양쪽 정점에 추가해줘야 한다!
			list.get(from).add(to);
			list.get(to).add(from);
		}
		
		bfs(1);
	}
}
