package baekjoon.solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * - https://www.acmicpc.net/problem/1697
 * - 클래스로 관리하지않고 배열로도 충분히 풀 수 있는 문제였다.
 * - 기존 풀이 : 메모리 22536 KB, 시간 256 ms
 * - 재풀이 : 메모리 21816 KB, 시간 252 ms
 */
public class HideAndSeek2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int[] count = new int[100001];

        int N = sc.nextInt();
        int K = sc.nextInt();

        queue.add(N);

        while (!queue.isEmpty()) {
            int currentElement = queue.poll();

            if (currentElement == K) {
                System.out.println(count[currentElement]);
                return;
            }

            addElement(queue, count, currentElement, currentElement+1);
            addElement(queue, count, currentElement, currentElement-1);
            addElement(queue, count, currentElement, currentElement*2);
        }

        System.out.println(0);
    }

    private static void addElement(Queue<Integer> queue, int[] count, int currentElement, int nextElement) {
        if (nextElement < 0 || nextElement > 100000) {
            return;
        }
        if (count[nextElement] != 0) { // 이미 지나온 숫자는 넘긴다. dp 방식과 유사하다. (피보나치 수열)
            return;
        }
        queue.add(nextElement);
        count[nextElement] = count[currentElement]+1; // 이전 횟수에 + 1
    }
}

