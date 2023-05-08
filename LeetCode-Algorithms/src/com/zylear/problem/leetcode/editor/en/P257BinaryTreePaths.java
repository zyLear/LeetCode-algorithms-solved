package com.zylear.problem.leetcode.editor.en;

//Given a binary tree, return all root-to-leaf paths. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
// Related Topics Tree Depth-first Search 
// 👍 2147 👎 121


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
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

        private List<String> result = new ArrayList<>();
        private Stack<String> stack = new Stack<>();

        public List<String> binaryTreePaths(TreeNode root) {
            findPath(root);
            return result;
        }

        public void findPath(TreeNode node) {
            if (node != null) {
                stack.push(String.valueOf(node.val));

                if (node.left == null && node.right == null) {
                    result.add(String.join("->", stack));
                }
                findPath(node.left);
                findPath(node.right);
                stack.pop();

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}