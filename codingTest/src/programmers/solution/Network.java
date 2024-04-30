package programmers.solution;

import java.util.*;

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * - dfs로 풀어봤음
 */
public class Network {
    public static void main(String[] args) {
        Network n = new Network();
//        System.out.println(s.solution(3, new int[][]{
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}
//        }));
        System.out.println(n.solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        }));
    }

    public int solution(int n, int[][] computers) {
        List<List<Integer>> networks = new ArrayList<>();
        boolean[] isVisited = new boolean[n];
        int answer = 0;

        for (int i=0; i<computers.length; i++) {
            networks.add(new ArrayList<>());
        }

        for (int i=0; i<computers.length; i++) {
            int[] computer = computers[i];
            for (int j=0; j<computer.length; j++) {
                if (i!=j && computer[j] == 1) {
                    networks.get(i).add(j);
                }
            }
        }

        for (int i=0; i<computers.length; i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i, networks);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(boolean[] isVisited, int computer, List<List<Integer>> networks) {
        isVisited[computer] = true;

        List<Integer> network = networks.get(computer);

        for (int n : network) {
            if (!isVisited[n]) {
                dfs(isVisited, n, networks);
            }
        }
    }

    // 모범 답안
//    public int solution(int n, int[][] computers) {
//        int answer = 0;
//        boolean[] visited = new boolean[n];
//
//        for (int i=0; i<n; i++) {
//            if (visited[i]) {
//                continue;
//            }
//            answer++;
//            checkAllConnectedComputers(computers, visited, i);
//        }
//
//        return answer;
//    }
//
//    private void checkAllConnectedComputers(final int[][] computers, boolean[] visited, int c) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(c);
//
//        while (!queue.isEmpty()) {
//            int element = queue.poll();
//
//            if (!visited[element]) {
//                visited[element] = true;
//            }
//
//            for (int i=0; i<computers[element].length; i++) {
//                if (visited[i]) {
//                    continue;
//                }
//                if (computers[element][i] == 1) {
//                    queue.offer(i);
//                }
//            }
//        }
//    }

    // 내 풀이1
//    public int solution(int n, int[][] computers) {
//        List<List<Integer>> list = new ArrayList<>();
//        boolean[] visited = new boolean[n];
//        int answer = 0;
//
//        for (int i=0; i<computers.length; i++) {
//            list.add(new ArrayList<>());
//        }
//
//        for (int i=0; i<computers.length; i++) {
//            for (int j=0; j<computers[i].length; j++) {
//                if (i == j) {
//                    continue;
//                }
//
//                if (computers[i][j] == 1) {
//                    list.get(i).add(j);
//                }
//            }
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//
//        for (int i=0; i<list.size(); i++) {
//            if (!visited[i]) {
//                answer++;
//            }
//            queue.add(i);
//            visited[i] = true;
//
//            while (!queue.isEmpty()) {
//                int node = queue.poll();
//
//                for (int j=0; j<list.get(node).size(); j++) {
//                    int linkedNodeIdx = list.get(node).get(j);
//
//                    if (visited[linkedNodeIdx]) {
//                        continue;
//                    }
//
//                    visited[linkedNodeIdx] = true;
//                    queue.add(linkedNodeIdx);
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    public int solution(int n, int[][] computers) {
//        List<Node> list = new ArrayList<>();
//        int answer = 0;
//
//        for (int i=0; i<n; i++) {
//            list.add(new Node(i));
//        }
//
//        for (int i=0; i<computers.length; i++) {
//            Node node = list.get(i);
//
//            for (int j=0; j<computers[i].length; j++) {
//                if (j == i || computers[i][j] == 0) {
//                    continue;
//                }
//                Node link = list.get(j);
//
//                node.addLink(link);
//            }
//        }
//
//        Stack<Node> stack = new Stack<>();
//
//        for (int i=0; i<n; i++) {
//            Node start = list.get(i);
//
//            if (start.isVisited) {
//                continue;
//            }
//            answer++;
//            start.isVisited = true;
//            stack.add(start);
//
//            while (!stack.isEmpty()) {
//                Node node = stack.pop();
//
//                for (Node link : node.links) {
//                    if (link.isVisited) {
//                        continue;
//                    }
//                    link.isVisited = true;
//                    stack.add(link);
//                }
//            }
//        }
//
//        return answer;
//    }
}

// 내 풀이2
//class Node {
//    int num;
//    boolean isVisited;
//    List<Node> links = new LinkedList<>();
//
//    Node(int num) {
//        this.num = num;
//    }
//
//    void addLink(Node node) {
//        links.add(node);
//    }
//}
