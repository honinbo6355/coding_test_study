package programmers.solution;

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/49191
 * - 플로이드 워셜 알고리즘
 * - https://gom20.tistory.com/178
 */
public class Rank {
    public static void main(String[] args) {
        Rank r = new Rank();
        System.out.println(r.solution(5, new int[][]{
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        }));
    }

    public int solution(int n, int[][] results) {
        int[][] graph = new int[n+1][n+1];
        int answer = 0;

        // 승패 구분
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;
        }

        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) { // ex : 1 > 3, 3 > 5 이라면 1 > 5 이 성립된다.
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                }
            }
        }

        for (int i=1; i<=n; i++) {
            int count = 0;
            for (int j=1; j<=n; j++) {
                if (graph[i][j] != 0) {
                    count++;
                }
            }
            if (count == n-1) { // 본인을 제외한 나머지 선수와 승패를 알수있다면 순위 계산이 가능하다.
                answer++;
            }
        }

        return answer;
    }
}
