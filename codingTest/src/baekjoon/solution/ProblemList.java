package baekjoon.solution;

import java.util.*;

/**
 * - https://www.acmicpc.net/problem/1766
 * - 참고 링크 : https://steady-coding.tistory.com/85
 * - 위상 정렬에 대해 알아야 하는 문제. 단순히 Queue를 활용하면 실패한다. bfs+priorityQueue를 알아야 한다.
 */
public class ProblemList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Problem> list = new ArrayList<>();

        for (int i=1; i<=N; i++) {
            list.add(new Problem(i));
        }

        for (int i=0; i<M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            Problem previousProblem = list.get(A-1);
            Problem nextProblem = list.get(B-1);

            previousProblem.getProblems().add(nextProblem);
            nextProblem.increaseOrder();
        }

        Queue<Problem> queue = new PriorityQueue<>();
        StringBuilder s = new StringBuilder();

        for (Problem problem : list) {
            if (problem.getOrders() == 0) {
                queue.add(problem);
            }
        }

        while (!queue.isEmpty()) {
            Problem current = queue.poll();
            s.append(current.getNum() + " ");

            for (Problem nextProblem : current.getProblems()) {
                nextProblem.decreaseOrder();
                if (nextProblem.getOrders() == 0) {
                    queue.add(nextProblem);
                }
            }
        }

        System.out.println(s);
    }
}

class Problem implements Comparable<Problem> {
    private int num;
    private int orders = 0;
    private List<Problem> problems = new ArrayList<>();

    Problem(int num) {
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public int getNum() {
        return num;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public void increaseOrder() {
        orders += 1;
    }

    public void decreaseOrder() {
        orders -= 1;
    }

    @Override
    public int compareTo(Problem p) {
        return Integer.compare(num, p.getNum());
    }
}

