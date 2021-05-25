package baekjoon.solution;

import java.util.Scanner;

public class RGB_Distance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] dp = new int[N][3]; // 발생하는 경우의 수의 누적합을 저장하는 dp 테이블.
        int[][] arr = new int[N][3];

        for (int i=0; i<N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        // dp에 1번집의 색칠 비용 저장
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i=1; i<N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        int answer = Integer.MAX_VALUE;

        for (int i=0; i<3; i++) {
            answer = Math.min(dp[N-1][i], answer);
        }

        System.out.println(answer);
    }
}

