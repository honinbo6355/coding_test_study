package programmers.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FarNode {
    public static void main(String[] args) {
        FarNode f = new FarNode();
        System.out.println(f.solution(6, new int[][]{
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        }));
    }

    public int solution(int n, int[][] edge) {
        List<FarNodeNode> nodes = new ArrayList<>();
        Queue<FarNodeNode> queue = new LinkedList<>();
        int maxDistance = Integer.MIN_VALUE;
        int answer = 0;

        for (int i=0; i<=n; i++) {
            nodes.add(new FarNodeNode(i));
        }

        for (int[] e : edge) {
            FarNodeNode start = nodes.get(e[0]);
            FarNodeNode end = nodes.get(e[1]);

            start.addLink(end);
            end.addLink(start);
        }

        FarNodeNode start = nodes.get(1);
        start.isVisited = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            FarNodeNode node = queue.poll();
            maxDistance = Math.max(node.distance, maxDistance);

            for (FarNodeNode link : node.links) {
                if (link.isVisited) {
                    continue;
                }
                link.isVisited = true;
                link.distance = node.distance+1;

                queue.add(link);
            }
        }

        for (FarNodeNode node : nodes) {
            if (node.distance == maxDistance) {
                answer++;
            }
        }

        return answer;
    }
}

class FarNodeNode {
    int num;
    boolean isVisited;
    int distance = 1;
    List<FarNodeNode> links = new LinkedList<>();

    FarNodeNode(int num) {
        this.num = num;
    }

    void addLink(FarNodeNode node) {
        links.add(node);
    }
}
