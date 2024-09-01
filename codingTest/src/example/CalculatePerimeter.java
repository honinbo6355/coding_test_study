package example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * - 1로 연결된 섬들 중 최대 둘레 구하기
 */
public class CalculatePerimeter {
    public static void main(String[] args) {
//        int[][] maps = new int[][] {
//                {0,0,1,0,0},
//                {0,1,1,0,1},
//                {0,0,1,0,1},
//                {1,1,1,0,1}
//        };

        int[][] maps = new int[][] {
                {1,0,1,1},
                {0,0,1,1},
                {1,1,0,1},
                {1,1,0,0}
        };
        CalculatePerimeter c = new CalculatePerimeter();
        System.out.println("Perimeter: " + c.solution(maps));
    }

    // - 첫번째 풀이(DFS)
//    public int solution(int[][] maps){
//        int answer = 0;
//        int rows = maps.length;
//        int cols = maps[0].length;
//        boolean[][] isVisited = new boolean[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (maps[i][j] == 1 && !isVisited[i][j]) {
//                    answer = Math.max(dfs(maps, isVisited, i, j), answer);
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    private int dfs(int[][] maps, boolean[][] isVisited, int x, int y) {
//        int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
//        int[] dy = {0, 0, 1, -1};
//        int rows = maps.length;
//        int cols = maps[0].length;
//
//        isVisited[x][y] = true;
//        int perimeter = 0;
//
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//            // 경계를 벗어나거나 0을 만나면 둘레를 1 증가
//            if (nx < 0 || nx >= rows || ny < 0 || ny >= cols || maps[nx][ny] == 0) {
//                perimeter++;
//            } else if (maps[nx][ny] == 1 && !isVisited[nx][ny]) {
//                perimeter += dfs(maps, isVisited, nx, ny);
//            }
//        }
//
//        return perimeter;
//    }

    // - 두번째 풀이(BFS)
    // - isTotalVisited 이라는 변수를 활용해서 이미 계산된 섬들은 패스하는 방법 활용
    public int solution(int[][] maps){
        // BFS
        // 0이거나, 벽이거나
        int answer = 0;
        int rowLen = maps.length;
        int columnLen = maps[0].length;

        boolean[][] isTotalVisited = new boolean[rowLen][columnLen];

        for (int rowIdx=0; rowIdx<rowLen; rowIdx++) {
            for (int columnIdx=0; columnIdx<columnLen; columnIdx++) {
                if (!isTotalVisited[rowIdx][columnIdx] && maps[rowIdx][columnIdx] == 1) {
                    int perimeter = bfs(maps, isTotalVisited, rowIdx, columnIdx, rowLen, columnLen);
                    answer = Math.max(answer, perimeter);
                }
            }
        }

        return answer;
    }

    private int bfs(int[][] maps, boolean[][] isTotalVisited, int rowIdx, int columnIdx, int rowLen, int columnLen) {
        int perimeter = 0;
        boolean[][] isVisited = new boolean[rowLen][columnLen];
        Queue<Integer[]> queue = new LinkedList<>();
        int[][] directions = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};

        isTotalVisited[rowIdx][columnIdx] = true;
        isVisited[rowIdx][columnIdx] = true;

        queue.offer(new Integer[] {rowIdx, columnIdx});

        while (!queue.isEmpty()) {
            Integer[] element = queue.poll();

            for (int[] direction : directions) {
                Integer[] moved = new Integer[] {element[0]+direction[0], element[1]+direction[1]};

                if (moved[0] < 0 || moved[0] >= rowLen || moved[1] < 0 || moved[1] >= columnLen) {
                    perimeter++;
                    continue;
                }
                if (maps[moved[0]][moved[1]] == 0) {
                    perimeter++;
                    continue;
                }
                if (isVisited[moved[0]][moved[1]]) {
                    continue;
                }
                isVisited[moved[0]][moved[1]] = true;
                isTotalVisited[moved[0]][moved[1]] = true;
                queue.offer(moved);
            }
        }

        return perimeter;
    }
}
