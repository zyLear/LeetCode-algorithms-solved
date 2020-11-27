package com.zylear.problem.leetcode.editor.en;

//Given a binary tree and a sum, determine if the tree has a root-to-leaf path s
//uch that adding up all the values along the path equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
// 
//
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22. 
//
// Related Topics Tree Depth-first Search 
// 👍 2514 👎 550


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P112PathSum {
    public static void main(String[] args) {
        // Solution solution = new P112PathSum().new Solution();
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

        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            } else {
                if (root.left == null && root.right == null) {
                    return sum - root.val == 0;
                } else {
                    return hasPathSum(root.left, sum - root.val)
                            || hasPathSum(root.right, sum - root.val);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
