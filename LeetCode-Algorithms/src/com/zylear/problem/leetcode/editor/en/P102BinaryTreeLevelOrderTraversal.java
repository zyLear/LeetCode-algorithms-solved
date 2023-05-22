package com.zylear.problem.leetcode.editor.en;

//Given a binary tree, return the level order traversal of its nodes' values. (i
//e, from left to right, level by level). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its level order traversal as: 
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics Tree Breadth-first Search 
// 👍 3775 👎 90


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.*;

public class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        // Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> result = new LinkedList<>();

            Queue<TreeNode> queue = new LinkedList<>();


            queue.add(root);


            while (!queue.isEmpty()) {

                List<Integer> levelList = new ArrayList<>();

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    levelList.add(node.val);
                    //先处理同一层
                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                if (!levelList.isEmpty()) {
                    result.add(levelList);
                }
            }

            return result;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
