package baekjoon.solution;

import java.util.Scanner;
import java.util.Stack;

/**
 * - 스택에 원소를 삽입할때는, 단순히 특정 수에 도달할 때까지 삽입
 * - 스택에서 원소를 연달아 빼낼 때 내림차순을 유지할 수 있는지 확인
 * - https://www.acmicpc.net/problem/1874
 */

// 풀이1
//public class StackPermutation {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        Stack<Integer> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//
//        for (int i=0; i<n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int num = 1, idx = 0;
//
//        while (idx < n) {
//            int count = arr[idx];
//
//            while (num <= count) {
//                stack.push(num);
//                num++;
//                sb.append("+");
//                sb.append("\n");
//            }
//            if (stack.peek() == count) {
//                stack.pop();
//                idx++;
//                sb.append("-");
//                sb.append("\n");
//            } else {
//                System.out.println("NO\n");
//                return;
//            }
//        }
//
//        System.out.println(sb.toString());
//    }
//}

// 풀이2
public class StackPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        int idx = 0, num = 1;
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        stack.push(num);
        sb.append("+").append("\n");

        while (num < n) {
            if (!stack.isEmpty()) {
                int element = stack.peek();

                if (element == arr[idx]) {
                    sb.append("-").append("\n");
                    stack.pop();
                    idx++;
                    continue;
                }
            }

            stack.push(++num);
            sb.append("+").append("\n");
        }

        while (!stack.isEmpty()) {
            int element = stack.pop();
            if (element == arr[idx++]) {
                sb.append("-").append("\n");
            } else {
                sb = new StringBuilder();
                sb.append("NO").append("\n");
                break;
            }
        }

        System.out.println(sb);
    }
}
