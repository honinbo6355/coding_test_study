package example;

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

    public int solution(int[][] maps){
        int answer = 0;
        int rows = maps.length;
        int cols = maps[0].length;
        boolean[][] isVisited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maps[i][j] == 1 && !isVisited[i][j]) {
                    answer = Math.max(dfs(maps, isVisited, i, j), answer);
                }
            }
        }

        return answer;
    }

    private int dfs(int[][] maps, boolean[][] isVisited, int x, int y) {
        int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
        int[] dy = {0, 0, 1, -1};
        int rows = maps.length;
        int cols = maps[0].length;

        isVisited[x][y] = true;
        int perimeter = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 경계를 벗어나거나 0을 만나면 둘레를 1 증가
            if (nx < 0 || nx >= rows || ny < 0 || ny >= cols || maps[nx][ny] == 0) {
                perimeter++;
            } else if (maps[nx][ny] == 1 && !isVisited[nx][ny]) {
                perimeter += dfs(maps, isVisited, nx, ny);
            }
        }

        return perimeter;
    }
}
