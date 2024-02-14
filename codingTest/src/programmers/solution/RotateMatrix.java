package programmers.solution;

import java.util.Arrays;

/*
    - 구현 문제.
    - 회전 시작 값만 저장해두고, 회전 끝나면 swap 해주면 됌
    - 아래처럼 회전 방향 잡는게 구현하기 더 쉬운듯
    - 참조 : https://dev-note-97.tistory.com/265
 */
public class RotateMatrix {
    public static void main(String[] args) {
        RotateMatrix r = new RotateMatrix();

        System.out.println(Arrays.toString(r.solution(6, 6, new int[][]{
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}
        })));

        System.out.println(Arrays.toString(r.solution(3, 3, new int[][]{
                {1,1,2,2},
                {1,2,2,3},
                {2,1,3,2},
                {2,2,3,3}
        })));

        System.out.println(Arrays.toString(r.solution(100, 97, new int[][]{
                {1,1,100,97}
        })));
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] maps = new int[rows][columns];

        int number = 0;

        // 행렬 초기화
        for (int row=0; row<rows; row++) {
            for (int column=0; column<columns; column++) {
                maps[row][column] = ++number;
            }
        }

        for (int i=0; i<queries.length; i++) {
            answer[i] = rotate(maps, queries[i]);
        }

        return answer;
    }

    private int rotate(int[][] maps, int[] query) {
        // 가독성 좋게 변수로 따로 분리
        int startRow = query[0]-1;
        int startColumn = query[1]-1;
        int endRow = query[2]-1;
        int endColumn = query[3]-1;

        int tempVal = maps[startRow][startColumn]; // 시작 숫자는 임시 변수에 보관한다.
        int minVal = tempVal; // 시작 숫자를 최소값 변수에 담음

        // 북 -> 남
        for (int row=startRow; row<endRow; row++) {
            maps[row][startColumn] = maps[row + 1][startColumn];
            minVal = Math.min(minVal, maps[row][startColumn]);
        }

        // 서 -> 동
        for (int column=startColumn; column<endColumn; column++) {
            maps[endRow][column] = maps[endRow][column+1];
            minVal = Math.min(minVal, maps[endRow][column]);
        }

        // 남 -> 북
        for (int row=endRow; row>startRow; row--) {
            maps[row][endColumn] = maps[row-1][endColumn];
            minVal = Math.min(minVal, maps[row][endColumn]);
        }

        // 동 -> 서
        for (int column=endColumn; column>startColumn; column--) {
            maps[startRow][column] = maps[startRow][column-1];
            minVal = Math.min(minVal, maps[startRow][column]);
        }
        maps[startRow][startColumn+1] = tempVal; // 임시 변수를 마지막으로 이동한 위치에 업데이트한다.

        return minVal;
    }
}
