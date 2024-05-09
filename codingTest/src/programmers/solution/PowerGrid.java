package programmers.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/86971?language=java
 * - 풀이 참고 : https://141227.tistory.com/293
 */
public class PowerGrid {
    static int[][] graph;

    public static void main(String[] args) {
        PowerGrid p = new PowerGrid();
        System.out.println(p.solution(9, new int[][] {
                {1,3},
                {2,3},
                {3,4},
                {4,5},
                {4,6},
                {4,7},
                {7,8},
                {7,9}
        }));
//        System.out.println(s.solution(4, new int[][] {
//                {1,2},
//                {2,3},
//                {3,4}
//        }));
    }

    public int solution(int n, int[][] wires) {
        graph = new int[n+1][n+1];
        int answer = n-1;

        // 전선이 연결되어 있는 구조를 graph로 구현
        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];

            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];

            // 순차적으로 끊는 작업
            graph[from][to] = 0;
            graph[to][from] = 0;

            answer = Math.min(answer, bfs(n, from)); // to 값으로는 끊지 않는 이유는, to 값에 연결되어있는 전선이 없다면 나 자신만 끊는 것이므로 답과는 거리가 멀어진다. 두 전력망의 차가 최대한 비슷해야 하기 때문에

            // 끊은것들 다시 롤백
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        return answer;
    }

    private int bfs(int n, int from) {
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n+1]; // 이미 방문했던 송전탑은 pass 하기 위한 변수

        queue.offer(from);
        isVisited[from] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int i=1; i<=n; i++) {
                if (graph[num][i] == 1 && !isVisited[i]) {
                    isVisited[i] = true;
                    queue.offer(i);
                    count++;
                }
            }
        }

        return Math.abs(count - (n - count));
    }
}
