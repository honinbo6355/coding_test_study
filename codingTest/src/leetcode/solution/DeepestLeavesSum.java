package leetcode.solution;

/**
 * - https://leetcode.com/problems/deepest-leaves-sum/description/
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int[] answer = new int[] {0};
        int[] depth = new int[] {0};

        findDepth(root, depth, 0);
        getSum(root, answer, depth[0], 1);
        return answer[0];
    }

    private void findDepth(TreeNode root, int[] depth, int currentDepth) {
        if (root == null) {
            return;
        }

        currentDepth++;

        if (root.left == null && root.right == null) {
            depth[0] = Math.max(depth[0], currentDepth);
            return;
        }

        findDepth(root.left, depth, currentDepth);
        findDepth(root.right, depth, currentDepth);
    }

    private void getSum(TreeNode root, int[] answer, int depth, int currentDepth) {
        if (root == null) {
            return;
        }

        if (depth == currentDepth) {
            answer[0] += root.val;
            return;
        }

        getSum(root.left, answer, depth, currentDepth+1);
        getSum(root.right, answer, depth, currentDepth+1);
    }
}

