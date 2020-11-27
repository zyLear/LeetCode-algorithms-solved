package com.zylear.problem.leetcode.editor.en;

//Given a binary tree, determine if it is height-balanced. 
//
// For this problem, a height-balanced binary tree is defined as: 
//
// 
// a binary tree in which the left and right subtrees of every node differ in he
//ight by no more than 1.
// 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: true
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -104 <= Node.val <= 104 
// 
// Related Topics Tree Depth-first Search 
// 👍 2798 👎 190


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P110BalancedBinaryTree {
    public static void main(String[] args) {
        // Solution solution = new P110BalancedBinaryTree().new Solution();
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

        boolean balanced = true;
        public boolean isBalanced(TreeNode root) {
            height(root);
            return balanced;
        }

        private int height(TreeNode node) {
            if (node == null ) {
                return 0;
            }
            int left = height(node.left) + 1;
            int right = height(node.right) + 1;
            if (Math.abs(left - right) > 1) {
                balanced = false;
            }
            return Math.max(left, right);
        }

        //简单解法  根据定义解题
        //本身的左右子树结点高度差绝对值小于等于1
        //左右结点 的左右子树结点高度差绝对值小于等于1
        //总的来说就是每个结点的左右子树的高度差绝对值小于等于1  注意是每个结点，相当于遍历树
        public boolean isBalanced1(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(Math.abs(depth(root.left))
                    - Math.abs(depth(root.right))) <= 1 &&
                    isBalanced1(root.left) &&
                    isBalanced1(root.right)
                    ;
        }

        public boolean isBalanced(TreeNode root, Boolean bool) {
            if (!bool) {
                return false;
            }
            if (root == null) {
                return true;
            }
            return isBalanced(root.left) &&
                    isBalanced(root.right)
                    && Math.abs(Math.abs(depth(root.left))
                    - Math.abs(depth(root.right))) <= 1;

        }


        public int depth(TreeNode node) {
            return depth(node, 1);
        }

        public int depth(TreeNode node, int parentDepth) {
            if (node == null) {
                return parentDepth;
            } else {
                parentDepth += 1;
                return Math.max(depth(node.left, parentDepth), depth(node.right, parentDepth));

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
