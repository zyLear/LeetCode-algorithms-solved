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

        private TreeNode prev;


        //利用中序遍历比较大小
        public boolean isValidBST(TreeNode root) {

            if (root == null) {
                return true;
            }

            if (!isValidBST(root.left)) {
                return false;
            }

            if (prev != null && prev.val >= root.val) {
                return false;
            }

            prev = root;

            return isValidBST(root.right);
        }

        public boolean isValidBST1(TreeNode root) {
            return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }


        public boolean isValidBST1(TreeNode node, Long min, Long max) {
            if (node == null) {
                return true;
            } else {
                if (node.val > min && node.val < max) {
                    if (isValidBST1(node.left, min, (long) node.val) &&
                            isValidBST1(node.right, (long) node.val, max)) {
                        return true;
                    }
                }
                return false;

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}