package baekjoon.solution;

import java.util.Arrays;
import java.util.Scanner;

public class SearchNumber {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i=0; i<A.length; i++) {
            A[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] B = new int[M];

        for (int i=0; i<B.length; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A); // 퀵소트로 오름차순 정렬

        for (int i=0; i<B.length; i++) {
            int left = 0;
            int right = A.length-1;

            // 이진탐색
            while (true) {
                if (left > right) { // 값이 존재하지 않는 경우
                    sb.append(0 + "\n");
                    break;
                }

                int mid = (left+right) / 2;

                if (A[mid] > B[i]) {
                    right = mid-1;
                } else if (A[mid] < B[i]) {
                    left = mid+1;
                } else {
                    sb.append(1 + "\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
