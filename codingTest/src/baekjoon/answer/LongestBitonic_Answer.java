package baekjoon.answer;

import java.io.IOException;
import java.util.Scanner;

/**
 * LIS, LDS 알고리즘 풀이 참조 사이트
 * - https://st-lab.tistory.com/136
 * - https://squareyun.tistory.com/27
 */
public class LongestBitonic_Answer {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N+1];

        for (int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }

        // 왼쪽에서 오른쪽으로 LIS 구하기
        int[] dpLR = new int[N+1];
        for (int i=1; i<=N; i++) {
            dpLR[i] = 1;
            for (int j=1; j<i; j++) {
                if (arr[i] > arr[j]) {
                    dpLR[i] = Math.max(dpLR[j]+1, dpLR[i]);
                }
            }
        }

        // 오른쪽에서 왼쪽으로 LIS 구하기
        int[] dpRL = new int[N+1];
        for (int i=N; i>0; i--) {
            dpRL[i] = 1;
            for (int j=N; j>i; j--) {
                if (arr[i] > arr[j]) {
                    dpRL[i] = Math.max(dpRL[j]+1, dpRL[i]);
                }
            }
        }

        // 두 dp 배열의 합의 최대값 찾기
        int maxVal = 0;
        for (int i=1; i<=N; i++) {
            maxVal = Math.max(dpLR[i] + dpRL[i], maxVal);
        }

        maxVal = maxVal-1; // 해당 원소 중복되므로 -1

        System.out.println(maxVal);
        sc.close();
    }
}

