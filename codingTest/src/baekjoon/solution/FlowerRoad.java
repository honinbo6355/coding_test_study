package baekjoon.solution;

import java.util.Scanner;

/**
 * - https://www.acmicpc.net/problem/14620
 */
public class FlowerRoad {
    private static int N;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int row=0; row<N; row++) {
            String[] strArr = sc.nextLine().split(" ");
            if (strArr.length != N) {
                throw new RuntimeException();
            }
            for (int column=0; column<N; column++) {
                map[row][column] = Integer.parseInt(strArr[column]);
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int count, int totalSum) {
        if (count == 3) {
            answer = Math.min(answer, totalSum);
            return;
        }

        for (int row=1; row<N-1; row++) {
            for (int column=1; column<N-1; column++) {
                if (isAvailable(row, column)) {
                    dfs(count+1, totalSum + visited(row, column)); // dfs로 모든 경우의 수 다 탐색

                    visitedClear(row, column); // 방문 이력 초기화
                }
            }
        }
    }

    private static boolean isAvailable(int row, int column) {
        if (visited[row][column]) {
            return false;
        }
        if (row < 0 || row >= N || column < 0 || column >= N) {
            return false;
        }

        for (int d=0; d<4; d++) {
            if (visited[row+dy[d]][column+dx[d]]) {
                return false;
            }
            if (row+dy[d] < 0 || row+dy[d] >= N || column+dx[d] < 0 || column+dx[d] >= N) {
                return false;
            }
        }

        return true;
    }

    private static void visitedClear(int row, int column) {
        visited[row][column] = false;

        for (int d=0; d<4; d++) {
            visited[row+dy[d]][column+dx[d]] = false;
        }
    }

    private static int visited(int row, int column) {
        int sum = map[row][column];
        visited[row][column] = true;

        for (int d=0; d<4; d++) {
            sum += map[row+dy[d]][column+dx[d]];
            visited[row+dy[d]][column+dx[d]] = true;
        }

        return sum;
    }
}
