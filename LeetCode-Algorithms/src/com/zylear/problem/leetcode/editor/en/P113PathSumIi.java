package com.zylear.problem.leetcode.editor.en;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's s
//um equals the given sum. 
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
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics Tree Depth-first Search 
// 👍 2286 👎 83


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P113PathSumIi {
    public static void main(String[] args) {
        // Solution solution = new P113PathSumIi().new Solution();
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

        private Stack<Integer> stack = new Stack<>();
        private List<List<Integer>> result = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root != null) {
                stack.push(root.val);
                if (root.left == null && root.right == null) {
                    if (sum - root.val == 0) {
                        System.out.println(stack);
                        result.add(new ArrayList<>(stack));
                    }
                } else {
                    pathSum(root.left, sum - root.val);
                    pathSum(root.right, sum - root.val);
                }
                stack.pop();
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
