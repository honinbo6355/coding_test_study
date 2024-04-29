package baekjoon.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * - https://www.acmicpc.net/problem/2606
 * - 이번에는 dfs로 문제 풀이
 * - 기존 풀이 : 메모리 18016 KB, 시간 247 MS
 * - 재풀이 : 메모리 17868 KB, 시간 232 MS
 */
public class Virus2 {
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int networkCount = sc.nextInt();
        List<List<Integer>> computers = new ArrayList<>();
        boolean[] isVisited = new boolean[num+1];

        for (int i=0; i<=num; i++) {
            computers.add(new ArrayList<>());
        }

        for (int i=0; i<networkCount; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            computers.get(c1).add(c2);
            computers.get(c2).add(c1);
        }

        isVisited[1] = true;

        for (int computer : computers.get(1)) {
            dfs(computer, computers, isVisited);
        }

        System.out.println(answer);
    }

    private static void dfs(int computer, List<List<Integer>> computers, boolean[] isVisited) {
        if (isVisited[computer]) {
            return;
        }
        answer++;
        isVisited[computer] = true;
        List<Integer> network = computers.get(computer);

        for (int c : network) {
            dfs(c, computers, isVisited);
        }
    }
}

