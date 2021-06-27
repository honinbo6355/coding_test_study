package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class TreePostorderTraversal {
    public List<Integer> answer = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return answer;
        }

        traversal(root);
        answer.add(root.val);

        return answer;
    }

    public void traversal(Node root) {
        if (root == null) {
            return;
        }

        for (Node node : root.children) {
            traversal(node);
            answer.add(node.val);
        }
    }
}
