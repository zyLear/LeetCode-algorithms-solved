package com.zylear.problem.leetcode.editor.en;

//Given the root of a binary tree, return the inorder traversal of its nodes' va
//lues. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,3,2]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,2]
//Output: [2,1]
// 
//
// Example 5: 
//
// 
//Input: root = [1,null,2]
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//
// Follow up: 
//
// Recursive solution is trivial, could you do it iteratively? 
//
// 
// Related Topics Hash Table Stack Tree 
// 👍 3901 👎 169


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            putLeftSize(root, stack);
            while (!stack.isEmpty()) {

                TreeNode node = stack.pop();
                list.add(node.val);

                TreeNode right = node.right;
                if (right != null) {
                    putLeftSize(right, stack);
                }
            }

            return list;
        }

        public void putLeftSize(TreeNode root, Stack<TreeNode> stack) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}