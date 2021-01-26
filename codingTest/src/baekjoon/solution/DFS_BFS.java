package baekjoon.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_BFS {
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		for (int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0; i<M; i++) {
			int idx = sc.nextInt();
			int val = sc.nextInt();
			
			graph.get(idx).add(val);
			graph.get(val).add(idx);
		}
		
		for (ArrayList<Integer> element : graph) {
			Collections.sort(element);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		
		for (int i=0; i<graph.get(start).size(); i++) {
			int vertex = graph.get(start).get(i);
			if (!visited[vertex]) {
				dfs(vertex);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int element = queue.poll();
			System.out.print(element + " ");
			
			for (int i=0; i<graph.get(element).size(); i++) {
				int vertex = graph.get(element).get(i);
				if (!visited[vertex]) {
					queue.offer(vertex);
					visited[vertex] = true;
				}
			}
		}
	}
}

