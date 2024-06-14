package leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * - https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 * - DFS로 풀면 시간 초과 발생함.
 * - 시간 복잡도는 DFS보다 BFS가 더 빠르다. DFS는 모든 경로를 다 탐색하지만, BFS는 최단 경로를 찾게되면 함수 종료됨.
 */
public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        FindIfPathExistsInGraph f = new FindIfPathExistsInGraph();
        System.out.println(f.validPath(3, new int[][] {{0,1},{1,2},{2,0}}, 0, 2));
        System.out.println(f.validPath(6, new int[][] {{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        boolean answer = false;

        for (int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            List<Integer> starts = list.get(edge[0]);
            List<Integer> ends = list.get(edge[1]);

            starts.add(edge[1]);
            ends.add(edge[0]);
        }

        queue.add(source);

        while (!queue.isEmpty()) {
            int element = queue.poll();

            if (element == destination) {
                answer = true;
                break;
            }

            for (int e : list.get(element)) {
                if (isVisited[e]) {
                    continue;
                }
                isVisited[e] = true;
                queue.add(e);
            }
        }

        return answer;
    }
}
