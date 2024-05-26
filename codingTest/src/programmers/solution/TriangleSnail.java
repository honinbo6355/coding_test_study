package programmers.solution;

import java.util.Arrays;

/*
- https://school.programmers.co.kr/learn/courses/30/lessons/68645
- 모범 답안 https://minhamina.tistory.com/58
- 반복문을 더 줄일 수 있다.
*/

public class TriangleSnail {
    public static void main(String[] args) {
        TriangleSnail t = new TriangleSnail();
        System.out.println(Arrays.toString(t.solution(4)));
        System.out.println(Arrays.toString(t.solution(5)));
    }

//    public int[] solution(int n) {
//        int[][] arr = new int[n][n];
//        int count = n;
//        int num = 1;
//
//        for (int i=0, j=0, k=0; i<n; i+=3, j+=2, k++) {
//            int row = j-1;
//            int column = k;
//            for (int l=0; l<count; l++) {
//                arr[++row][column] = num++;
//            }
//            count--;
//            for (int l=0; l<count; l++) {
//                arr[row][++column] = num++;
//            }
//            count--;
//            for (int l=0; l<count; l++) {
//                arr[--row][--column] = num++;
//            }
//            count--;
//        }
//
//        return Arrays.stream(arr)
//                .flatMapToInt(Arrays::stream)
//                .filter(e -> e != 0)
//                .toArray();
//    }

    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int num = 1, count = 0, row = -1, column = 0;

        while (count < n) {
            for (int i=count; i<n; i++) {
                arr[++row][column] = num++;
            }
            count++;

            for (int j=count; j<n; j++) {
                arr[row][++column] = num++;
            }
            count++;

            for (int k=count; k<n; k++) {
                arr[--row][--column] = num++;
            }
            count++;
        }

        return Arrays.stream(arr)
                .flatMapToInt(a -> Arrays.stream(a))
                .filter(e -> e != 0)
                .toArray();
    }
}

