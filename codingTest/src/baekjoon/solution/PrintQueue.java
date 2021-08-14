package baekjoon.solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * {초기 위치, 중요도} 형태로 queue에 넣는게 중요하다.
 * 중요도 순으로 옮긴 후, 초기 위치 인덱스를 활용해서 찾고자 했던 요소인지 확인한다.
 */

public class PrintQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int cnt = sc.nextInt();

        for (int i=0; i<cnt; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Queue<int[]> queue = new LinkedList<>();
            int order = 0;

            for (int j=0; j<N; j++) {
                // {초기 위치, 중요도}
                queue.offer(new int[] {j, sc.nextInt()});
            }

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                boolean isExist = false;

                for (int[] element : queue) {
                    if (current[1] < element[1]) { // 현재 요소값보다 더 큰 요소가 존재할 경우
                        isExist = true;
                        break;
                    }
                }

                // 존재할 경우 뒤쪽에 추가한다. 재배치 과정.
                if (isExist) {
                    queue.offer(current);
                } else {
                    order++;
                    if (current[0] == M) { // 찾고자했던 요소일 경우
                        sb.append(order).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}

