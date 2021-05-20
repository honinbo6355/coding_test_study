package baekjoon.solution;

import java.util.Scanner;

public class FunnyExecFunc {
    private static long[][][] dp = new long[51][51][51]; // 메모이제이션을 위한 dp 테이블

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            String str = String.format("w(%d, %d, %d) = %d", a, b, c, w(a,b,c));
            sb.append(str + "\n");
        }

        System.out.println(sb);
    }

    private static long w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        // dp 테이블에 값이 존재하면 dp 값 return
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a > 20 || b > 20 || c > 20) {
            dp[a][b][c] = w(20, 20, 20);
            return dp[a][b][c];
        }

        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return dp[a][b][c];
        }

        dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return dp[a][b][c];
    }
}

