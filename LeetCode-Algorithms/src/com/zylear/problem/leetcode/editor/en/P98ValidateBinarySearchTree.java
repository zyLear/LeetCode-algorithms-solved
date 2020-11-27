package com.zylear.problem.leetcode.editor.en;

//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics Tree Depth-first Search 
// 👍 4875 👎 599


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
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
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }


        public boolean isValidBST(TreeNode node, Long min, Long max) {
            if (node == null) {
                return true;
            } else {
                if (node.val > min && node.val < max) {
                    if (isValidBST(node.left, min, (long) node.val) &&
                            isValidBST(node.right, (long) node.val, max)) {
                        return true;
                    }
                }
                return false;

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}