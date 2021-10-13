package baekjoon.solution;

import java.util.Scanner;

/**
 * dfs, bfs 문제. 둘 중 어느 방식으로 풀어도 상관없음.
 */
public class OrganicCabbage {
    static int count;
    static int[][] map;
    static boolean[][] visited;
    static int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}}; // 북,동,남,서

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuffer sb = new StringBuffer();

        for (int i=0; i<T; i++) {
            int M = sc.nextInt(),
                N = sc.nextInt(),
                K = sc.nextInt();

            count = 0;
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j=0; j<K; j++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();

                map[Y][X] = 1;
            }

            for (int raw=0; raw<N; raw++) {
                for (int column=0; column<M; column++) {
                    if (map[raw][column] == 1 && !visited[raw][column]) {
                        dfs(raw, column);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int raw, int column) {
        visited[raw][column] = true;

        for (int i=0; i<direction.length; i++) {
            int movedRaw = raw+direction[i][0];
            int movedColumn = column+direction[i][1];

            // 좌표 범위를 넘어설 경우
            if (movedRaw < 0 || movedRaw >= map.length || movedColumn < 0 || movedColumn >= map[0].length) {
                continue;
            }

            // 이미 방문했을 경우
            if (visited[movedRaw][movedColumn]) {
                continue;
            }

            // 배추가 심어져 있지 않았을 경우
            if (map[movedRaw][movedColumn] != 1) {
                continue;
            }

            dfs(movedRaw, movedColumn);
        }
    }
}

