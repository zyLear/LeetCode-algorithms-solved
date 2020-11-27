package com.zylear.problem.leetcode.editor.en;

//Given a binary tree, flatten it to a linked list in-place. 
//
// For example, given the following tree: 
//
// 
//    1
//   / \
//  2   5
// / \   \
//3   4   6
// 
//
// The flattened tree should look like: 
//
// 
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// 
// Related Topics Tree Depth-first Search 
// 👍 3531 👎 374


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
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
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            flattenRecursive(root);

        }


        public TreeNode flattenRecursive(TreeNode node) {
            if (node.left == null && node.right == null) {
                return node;
            } else if (node.left == null) {
                return flattenRecursive(node.right);
            } else if (node.right == null) {
                TreeNode leftTail = flattenRecursive(node.left);
                node.right = node.left;
                node.left = null;
                return leftTail;
            } else {
                TreeNode leftTail = flattenRecursive(node.left);
                TreeNode rightTail = flattenRecursive(node.right);
                TreeNode rightTemp = node.right;
                node.right = node.left;
                node.left = null;
                leftTail.right = rightTemp;
                return rightTail;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}