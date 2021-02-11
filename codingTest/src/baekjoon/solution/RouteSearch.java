package baekjoon.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RouteSearch {
	public static void main(String[] args) throws IOException {
		// 플로이드-와샬 알고리즘 관련 문제이다
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// i에서 j까지 갈 수 있는지 확인
		// i에서 k를 가고, k에서 j로 가는 방법 체크
		for (int k=0; k<N; k++) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					// i -> j로 가는 방법은 현재 graph 배열 값이다. k를 거쳐가는 방법이 가능한지만 체크하면 된다.
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}
