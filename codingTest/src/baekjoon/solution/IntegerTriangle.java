package baekjoon.solution;

import java.util.Scanner;

/**
 * - https://dding9code.tistory.com/10
 */

public class IntegerTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        int answer = dp[n][1];

        for (int i=2; i<=n; i++) {
            answer = Math.max(dp[n][i], answer);
        }

        System.out.println(answer);
    }
}
