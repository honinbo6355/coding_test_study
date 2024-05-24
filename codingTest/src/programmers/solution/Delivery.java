package programmers.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/12978
 * - dfs, 백트래킹 문제
 * - bfs로 풀려고하면 백트래킹하기 애매하다..
 */

// 풀이1
//public class Delivery {
//    public static void main(String[] args) {
//        Delivery d = new Delivery();
//        System.out.println(d.solution(5, new int[][]{
//                {1, 2, 1},
//                {2, 3, 3},
//                {5, 2, 2},
//                {1, 4, 2},
//                {5, 3, 1},
//                {5, 4, 2}
//        }, 3));
//
//        System.out.println(d.solution(6, new int[][]{
//                {1,2,1},
//                {1,3,2},
//                {2,3,2},
//                {3,4,3},
//                {3,5,2},
//                {3,5,3},
//                {5,6,1}
//        }, 4));
//    }
//
//    public int solution(int N, int[][] road, int K) {
//        List<List<Node>> list = new ArrayList<>();
//        boolean[] isVisited = new boolean[N+1];
//        boolean[] visited = new boolean[N+1];
//        int result = 0;
//
//        for (int i=0; i<=N; i++) {
//            list.add(new ArrayList<>());
//        }
//
//        for (int[] r : road) {
//            List<Node> start = list.get(r[0]);
//            List<Node> end = list.get(r[1]);
//
//            start.add(new Node(r[1], r[2]));
//            end.add(new Node(r[0], r[2]));
//        }
//
//        isVisited[1] = true;
//        visited[1] = true;
//
//        dfs(isVisited, visited, list, 1, K, 0);
//
//        for (int i=1; i<=N; i++) {
//            if (visited[i]) {
//                result++;
//            }
//        }
//
//        return result;
//    }
//
//    private void dfs(boolean[] isVisited, boolean[] visited, List<List<Node>> list, int start, int K, int totalDistance) {
//        for (int i=0; i<list.get(start).size(); i++) {
//            int end = list.get(start).get(i).end;
//            int distance = list.get(start).get(i).distance;
//
//            if (!isVisited[end] && totalDistance + distance <= K) {
//                isVisited[end] = true;
//                visited[end] = true;
//                dfs(isVisited, visited, list, end, K, totalDistance + distance);
//                isVisited[end] = false;
//            }
//        }
//    }
//}
//
//class Node {
//    int end;
//    int distance;
//
//    Node(int end, int distance) {
//        this.end = end;
//        this.distance = distance;
//    }
//}

// 풀이 2(32번 시간초과)
//public class Delivery {
//    static int answer = 1;
//
//    public static void main(String[] args) {
//        Delivery d = new Delivery();
//        System.out.println(d.solution(5, new int[][]{
//                {1, 2, 1},
//                {2, 3, 3},
//                {5, 2, 2},
//                {1, 4, 2},
//                {5, 3, 1},
//                {5, 4, 2}
//        }, 3));
//
//        System.out.println(d.solution(6, new int[][]{
//                {1,2,1},
//                {1,3,2},
//                {2,3,2},
//                {3,4,3},
//                {3,5,2},
//                {3,5,3},
//                {5,6,1}
//        }, 4));
//    }
//
//    public int solution(int N, int[][] road, int K) {
//        List<List<Node>> list = new ArrayList<>();
//        boolean[] isVisited = new boolean[N+1];
//
//        for (int i=0; i<=N; i++) {
//            list.add(new ArrayList<>());
//        }
//
//        for (int[] r : road) {
//            List<Node> current = list.get(r[0]);
//            List<Node> next = list.get(r[1]);
//
//            current.add(new Node(r[1], r[2]));
//            next.add(new Node(r[0], r[2]));
//        }
//
//        for (int i=2; i<=N; i++) {
//            isVisited[1] = true;
//            dfs(list, 1, i, 0, K, isVisited);
//            isVisited[i] = false;
//        }
//
//        return answer;
//    }
//
//    private void dfs(List<List<Node>> list, int start, int target, int totalTime, int K, boolean[] isVisited) {
//        List<Node> nodes = list.get(start);
//
//        for (Node node : nodes) {
//            if (!isVisited[node.idx] && node.time+totalTime <= K) {
//                isVisited[node.idx] = true;
//                if (node.idx == target) {
//                    answer++;
//                    return;
//                }
//                dfs(list, node.idx, target, node.time+totalTime, K, isVisited);
//                isVisited[node.idx] = false;
//            }
//        }
//    }
//}
//
//class Node {
//    int idx;
//    int time;
//
//    Node(int idx, int time) {
//        this.idx = idx;
//        this.time = time;
//    }
//}

public class Delivery {
    public static void main(String[] args) {
        Delivery d = new Delivery();
        System.out.println(d.solution(5, new int[][]{
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}
        }, 3));

        System.out.println(d.solution(6, new int[][]{
                {1,2,1},
                {1,3,2},
                {2,3,2},
                {3,4,3},
                {3,5,2},
                {3,5,3},
                {5,6,1}
        }, 4));
    }

    public int solution(int N, int[][] road, int K) {
        List<List<Node>> list = new ArrayList<>();
        boolean[] isVisited = new boolean[N+1];
        boolean[] resultVisited = new boolean[N+1];

        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] r : road) {
            List<Node> current = list.get(r[0]);
            List<Node> next = list.get(r[1]);

            current.add(new Node(r[1], r[2]));
            next.add(new Node(r[0], r[2]));
        }

        isVisited[1] = true;
        dfs(list, 1, isVisited, resultVisited, 0, K);

        int answer = 1;

        for (boolean r : resultVisited) {
            if (r) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(List<List<Node>> list, int startIdx, boolean[] isVisited, boolean[] resultVisited, int totalTime, int K) {
        List<Node> nodes = list.get(startIdx);

        for (Node node : nodes) {
            if (!isVisited[node.idx] && node.time+totalTime <= K) {
                isVisited[node.idx] = true;
                resultVisited[node.idx] = true;
                dfs(list, node.idx, isVisited, resultVisited, node.time+totalTime, K);
                isVisited[node.idx] = false;
            }
        }
    }
}

class Node {
    int idx;
    int time;

    Node(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }
}
