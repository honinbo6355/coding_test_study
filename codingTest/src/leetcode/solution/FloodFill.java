package leetcode.solution;

import java.util.Arrays;

public class FloodFill {
    public int startColor;
    public boolean[][] visited;

    public static void main(String[] args) {
        FloodFill f = new FloodFill();

        int[][] image = new int[][]{{0,0,0},{0,1,1}};

        f.floodFill(image, 1, 1, 1);
        for (int[] img : image) {
            System.out.println(Arrays.toString(img));
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        startColor = image[sr][sc];
        visited = new boolean[image.length][image[0].length];

        return dfs(image, sr, sc, newColor);
    }

    public int[][] dfs(int[][] image, int sr, int sc, int newColor) {
        // row, column이 벗어났을 경우 return
        if (image.length <= sr || image[0].length <= sc || sr < 0 || sc < 0) {
            return image;
        }

        // 이미 방문했을 경우
        if (visited[sr][sc]) {
            return image;
        }

        // startColor와 같지 않을 경우
        if (image[sr][sc] != startColor) {
            return image;
        }

        image[sr][sc] = newColor;
        visited[sr][sc] = true;

        dfs(image, sr-1, sc, newColor); // 북쪽으로 dfs 실행
        dfs(image, sr, sc+1, newColor); // 동쪽으로 dfs 실행
        dfs(image, sr+1, sc, newColor); // 남쪽으로 dfs 실행
        dfs(image, sr, sc-1, newColor); // 서쪽으로 dfs 실행

        return image;
    }
}
