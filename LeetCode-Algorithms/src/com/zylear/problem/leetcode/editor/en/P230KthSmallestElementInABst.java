package com.zylear.problem.leetcode.editor.en;

//Given a binary search tree, write a function kthSmallest to find the kth small
//est element in it. 
//
// 
//
// Example 1: 
//
// 
//Input: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//Output: 1 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//Output: 3
// 
//
// Follow up: 
//What if the BST is modified (insert/delete operations) often and you need to f
//ind the kth smallest frequently? How would you optimize the kthSmallest routine?
// 
//
// 
// Constraints: 
//
// 
// The number of elements of the BST is between 1 to 10^4. 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements. 
// 
// Related Topics Binary Search Tree 
// 👍 3237 👎 75


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P230KthSmallestElementInABst {
    public static void main(String[] args) {
        // Solution solution = new P230KthSmallestElementInABst().new Solution();
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

        private int min;
        private int count;

        public int kthSmallest(TreeNode root, int k) {

            count = k;
            inorderTree(root);
            return min;
        }

        public void inorderTree(TreeNode treeNode) {
            if (treeNode != null) {
                inorderTree(treeNode.left);

                count--;
                if (count == 0) {
                    min = treeNode.val;
                    return;
                } else if (count < 0) {
                    return;
                }

                inorderTree(treeNode.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
