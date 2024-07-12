package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

// - https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
// 첫번째 풀이
//public class TreePostorderTraversal {
//    public List<Integer> answer = new ArrayList<>();
//
//    public List<Integer> postorder(Node root) {
//        if (root == null) {
//            return answer;
//        }
//
//        traversal(root);
//        answer.add(root.val);
//
//        return answer;
//    }
//
//    public void traversal(Node root) {
//        if (root == null) {
//            return;
//        }
//
//        for (Node node : root.children) {
//            traversal(node);
//            answer.add(node.val);
//        }
//    }
//}

// 두번째 풀이
public class TreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        for (Node n : node.children) {
            dfs(n, list);
        }

        list.add(node.val);
    }
}
