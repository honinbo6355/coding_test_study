package baekjoon.answer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 풀이 접근 방법 참고 : https://hoho325.tistory.com/151
 */
public class ElectricWire_Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N+1][2]; // A전봇대 값, B전봇대 값을 저장하고 있는 2차원 배열
        int[] dp = new int[N+1]; // LIS를 구하기 위한 dp 테이블
        int maxInstall = 1; // 가장 많이 설치할 수 있는 개수

        for (int i=1; i<=N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // A전봇대 값을 기준으로 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // LIS 구하는 코드
        for (int i=1; i<=N; i++) {
            dp[i] = 1;
            for (int j=1; j<i; j++) {
                if (arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            maxInstall = Math.max(maxInstall, dp[i]); // maxInstall값이 LIS값이라고 보면 되는 듯.
        }

        // 두 전봇대 사이의 전깃줄의 개수 - 가장 많이 설치할 수 있는 개수
        System.out.println(N - maxInstall);
    }
}

