package leetcode.solution;

/**
 * - https://leetcode.com/problems/all-paths-from-source-to-target/
 */

import java.util.ArrayList;
import java.util.List;

// 첫번째 풀이
//public class AllPathsFromSourceToTarget {
//    public static void main(String[] args) {
//        AllPathsFromSourceToTarget a = new AllPathsFromSourceToTarget();
//        System.out.println(a.allPathsSourceTarget(new int[][] {
//                {1,2},
//                {3},
//                {3},
//                {}
//        }));
////        System.out.println(a.allPathsSourceTarget(new int[][] {
////                {4,3,1},
////                {3,2,4},
////                {3},
////                {4},
////                {}
////        }));
//    }
//
//    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> subset = new ArrayList<>();
//        boolean[] isVisited = new boolean[graph.length];
//
//        subset.add(0);
//        isVisited[0] = true;
//
//        dfs(list, subset, isVisited, graph, 0, graph.length-1);
//        return list;
//    }
//
//    private void dfs(List<List<Integer>> list, List<Integer> subset, boolean[] isVisited, int[][] graph, int idx, int target) {
//        if (idx == target) {
//            list.add(new ArrayList<>(subset));
//            return;
//        }
//
//        for (int i=0; i<graph[idx].length; i++) {
//            int element = graph[idx][i];
//
//            if (!isVisited[element]) {
//                subset.add(element);
//                isVisited[element] = true;
//                dfs(list, subset, isVisited, graph, element, target);
//                subset.remove(subset.size()-1);
//                isVisited[element] = false;
//            }
//        }
//    }
//}

// 두번째 풀이
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        AllPathsFromSourceToTarget a = new AllPathsFromSourceToTarget();
        System.out.println(a.allPathsSourceTarget(new int[][] {
                {1,2},
                {3},
                {3},
                {}
        }));
//        System.out.println(a.allPathsSourceTarget(new int[][] {
//                {4,3,1},
//                {3,2,4},
//                {3},
//                {4},
//                {}
//        }));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.length];

        isVisited[0] = true;
        subList.add(0);

        dfs(result, subList, graph, 0, graph.length-1, isVisited);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> subList, int[][] graph, int path, int target, boolean[] isVisited) {
        if (path == target) {
            result.add(new ArrayList<>(subList));
            return;
        }

        for (int p : graph[path]) {
            if (!isVisited[p]) {
                subList.add(p);
                isVisited[p] = true;
                dfs(result, subList, graph, p, target, isVisited);
                subList.remove(subList.size()-1);
                isVisited[p] = false;
            }
        }
    }
}
