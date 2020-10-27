package leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		// root => bottom 순으로 탐색
		// 같은 depth에 있는 element들을 list에 담아 result 리스트의 첫번째 인덱스에 add
		// 같은 depth에 있는 element들을 탐색하면서 leaf node를 queue에 담는다
		// queue가 비어있으면 모든 node를 다 탐색했다는 것
		
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		
        if (root == null) {
        	return result;
        }
        
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int size  = queue.size(); // 중요
            List<Integer> curr = new ArrayList<>();
            
			while (size > 0) {
				TreeNode node = queue.remove();
				curr.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				size--;
			}
			result.add(0, curr);
		}
		return result;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
