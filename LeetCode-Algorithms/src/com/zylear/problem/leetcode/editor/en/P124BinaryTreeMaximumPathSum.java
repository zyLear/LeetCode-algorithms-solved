package com.zylear.problem.leetcode.editor.en;

//Given a non-empty binary tree, find the maximum path sum. 
//
// For this problem, a path is defined as any node sequence from some starting n
//ode to any node in the tree along the parent-child connections. The path must co
//ntain at least one node and does not need to go through the root.
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3]
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 3 * 104]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Depth-first Search 
// 👍 4760 👎 346


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        // Solution solution = new P124BinaryTreeMaximumPathSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        private Integer max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxPathSumFromNode(root);
            return max;
        }

        public int maxPathSumFromNode(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = Math.max(maxPathSumFromNode(node.left), 0);
            int right = Math.max(maxPathSumFromNode(node.right), 0);
            int count = left + right + node.val;
            max = Math.max(max, count);
            return node.val + Math.max(left, right);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
