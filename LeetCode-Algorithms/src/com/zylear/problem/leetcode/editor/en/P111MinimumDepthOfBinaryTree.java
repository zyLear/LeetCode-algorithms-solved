package com.zylear.problem.leetcode.editor.en;

//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 105]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Depth-first Search Breadth-first Search 
// 👍 1938 👎 778


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        // Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
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

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                //只要有一个结点空  就取另一个结点的最小深度
                if (root.left == null && root.right == null) {
                    return 1;
                } else if (root.left == null) {
                    return minDepth(root.right) + 1;
                } else if (root.right == null) {
                    return minDepth(root.left) + 1;
                } else {
                    return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
