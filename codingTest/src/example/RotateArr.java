package example;

import java.util.Arrays;

/**
 * - https://velog.io/@danbibibi/2%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B4%EC%97%90%EC%84%9C-90%EB%8F%84-%ED%9A%8C%EC%A0%84-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 */
public class RotateArr {
    public static void main(String[] args) {
        RotateArr r = new RotateArr();
//        int[][] image = {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };

        int[][] image = {
                {207,207,207,84},
                {207,207,84,255},
                {207,84,84,207},
                {84,255,207,0}
        };

        System.out.println(Arrays.toString(r.solution(image)));
    }

    public int[][] solution(int[][] image) {
        int n = image.length;
        int[][] answer = new int[2*n][2*n];

        fill(answer, image, 0, n, 0, n);

        int[][] rotatedTwo = rotate(image, n);
        fill(answer, rotatedTwo, 0, n, n, 2*n);

        int[][] rotatedFour = rotate(rotatedTwo, n);
        fill(answer, rotatedFour, n, 2*n, n, 2*n);

        int[][] rotatedThree = rotate(rotatedFour, n);
        fill(answer, rotatedThree, n, 2*n, 0, n);

        return answer;
    }

    // 시계 방향으로 90도 회전
    // 원본 배열 탐색 : 0번째 로우 ~ 마지막 로우까지, 0번째 컬럼부터 마지막 컬럼까지
    // 회전되는 배열 초기화 방식 : 0번째 로우 ~ 마지막 로우까지, 마지막 컬럼부터 0번째 컬럼까지
    private int[][] rotate(int[][] image, int n) {
        int[][] rotated = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                rotated[j][n-1-i] = image[i][j];
            }
        }

        return rotated;
    }

    private void fill(int[][] answer, int[][] image, int startRow, int endRow, int startColumn, int endColumn) {
        for (int row=startRow; row<endRow; row++) {
            for (int column=startColumn; column<endColumn; column++) {
                answer[row][column] = image[row-startRow][column-startColumn];
            }
        }
    }
}
