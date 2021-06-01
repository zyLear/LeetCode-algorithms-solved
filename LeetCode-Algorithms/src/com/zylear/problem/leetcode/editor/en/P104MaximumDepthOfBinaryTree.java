package com.zylear.problem.leetcode.editor.en;

//Given a binary tree, find its maximum depth. 
//
// The maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given binary tree [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// return its depth = 3. 
// Related Topics Tree Depth-first Search 
// 👍 3170 👎 83


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
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

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
            }
        }


        //************************************************
        public int maxDepth1(TreeNode root) {

            return maxDepth(root, 0);

        }


        public int maxDepth(TreeNode node, int currentCount) {
            if (node == null) {
                return currentCount;
            }

            currentCount += 1;

            return Math.max(maxDepth(node.left, currentCount),
                    maxDepth(node.right, currentCount));
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}


