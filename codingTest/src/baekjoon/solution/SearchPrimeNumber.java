package baekjoon.solution;

import java.util.Scanner;

/**
 * 필요한 개념 : 에라토스테네스의 체
 */

public class SearchPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N+1];

        // 배열에 2 ~ N 값 저장
        for (int i=2; i<=N; i++) {
            arr[i] = i;
        }

        for (int i=2; i<=N/2; i++) {
            if (arr[i] == 0) continue; // 이미 체크된 수의 배수는 확인하지 않는다.
            for (int j=i+i; j<=N; j+=i) { // 배수들을 0으로 초기화하면서 소수가 아닌 수 제거.
                arr[j] = 0;
            }
        }

        for (int i=M; i<=N; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
