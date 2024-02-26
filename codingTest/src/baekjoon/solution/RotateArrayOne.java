package baekjoon.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16926
 * https://wiselog.tistory.com/119
 */

public class RotateArrayOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[h][w];
        for (int row=0; row<h; row++) {
            st = new StringTokenizer(br.readLine());
            for (int column=0; column<w; column++) {
                arr[row][column] = Integer.parseInt(st.nextToken());
            }
        }

        int count = Math.min(h, w) / 2; // 돌아가는 라인의 수(외우기)
        for (int i=0; i<n; i++) {
            for (int j=0; j<count; j++) {
                int temp = arr[j][j];

                for (int column=j+1; column<w-j; column++) { // 동 -> 서
                    arr[j][column-1] = arr[j][column];
                }

                for (int row=j+1; row<h-j; row++) { // 남 -> 북
                    arr[row-1][w-1-j] = arr[row][w-1-j];
                }

                for (int column=w-2-j; column>=j; column--) { // 서 -> 동
                    arr[h-1-j][column+1] = arr[h-1-j][column];
                }

                for (int row=h-2-j; row>=j; row--) { // 북 -> 남
                    arr[row+1][j] = arr[row][j];
                }

                arr[j+1][j] = temp;
            }
        }

        for (int row=0; row<h; row++) {
            for (int column=0; column<w; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }
    }
}
