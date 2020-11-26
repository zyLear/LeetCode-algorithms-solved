package com.zylear.problem.leetcode.editor.en;

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric aro
//und its center). 
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric: 
//
// 
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// But the following [1,2,2,null,3,null,3] is not: 
//
// 
//    1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// Follow up: Solve it both recursively and iteratively. 
// Related Topics Tree Depth-first Search Breadth-first Search 
// 👍 5079 👎 121


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P101SymmetricTree {
    public static void main(String[] args) {
//        Solution solution = new P101SymmetricTree().new Solution();
        // TO TEST

        //leetcode submit region begin(Prohibit modification and deletion)
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
        class Solution {
            public boolean isSymmetric(TreeNode root) {
                return isSymmetric(root, root);
            }

            public boolean isSymmetric(TreeNode left, TreeNode right) {

                if (left == null && right == null) {
                    return true;
                }

                if (left == null || right == null) {
                    return false;
                }

                if (left.val == right.val &&
                        isSymmetric(left.left, right.right) &&
                        isSymmetric(left.right, right.left)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
    }


}

