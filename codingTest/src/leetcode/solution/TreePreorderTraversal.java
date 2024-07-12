package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

// - https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
// 첫번째 풀이
//public class TreePreorderTraversal {
//    public List<Integer> answer = new ArrayList<>();
//
//    public List<Integer> preorder(Node root) {
//        if (root == null) {
//            return answer;
//        }
//
//        answer.add(root.val);
//
//        for (Node node : root.children) {
//            preorder(node);
//        }
//
//        return answer;
//    }
//}

// 두번째 풀이
public class TreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        dfs(root, answer);
        return answer;
    }

    private void dfs(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        for (Node n : node.children) {
            dfs(n, list);
        }
    }
}
