package baekjoon.solution;

import java.util.*;

// bfs를 이용한 문제. Queue에 이동하는 경우의 수를 저장하면서 순회한다.

public class HideAndSeek {
    static boolean[] visited = new boolean[100001]; // 방문 유무

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int answer = bfs(N, K);
        System.out.println(answer);
    }

    private static int bfs(int N, int K) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Move current = queue.poll();

            // 동생을 찾았을 경우
            if (current.location == K) {
                return current.second;
            }

            checkMove(queue, current.location-1, current.second+1);
            checkMove(queue, current.location+1, current.second+1);
            checkMove(queue, current.location*2, current.second+1);
        }

        return 0;
    }

    private static void checkMove(Queue<Move> queue, int location, int second) {
        if (location < 0 || location > 100000) {
            return;
        }

        // 방문 안했으면 queue에 add
        if (visited[location] == false) {
            queue.add(new Move(location, second));
            visited[location] = true;
        }
    }
}

class Move {
    int location; // 위치
    int second; // 초

    Move(int location, int second) {
        this.location = location;
        this.second = second;
    }
}

