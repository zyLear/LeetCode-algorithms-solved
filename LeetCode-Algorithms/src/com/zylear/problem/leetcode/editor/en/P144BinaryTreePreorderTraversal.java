package com.zylear.problem.leetcode.editor.en;

//Given the root of a binary tree, return the preorder traversal of its nodes' v
//alues. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,2,3]
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
//Output: [1,2]
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
// Related Topics Stack Tree 
// 👍 1873 👎 71


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class P144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            stack.push(root);
            while (!stack.isEmpty()) {

                TreeNode node = stack.pop();
                list.add(node.val);

                TreeNode right = node.right;
                if (right != null) {
                    stack.push(right);
                }
                TreeNode left = node.left;
                if (left != null) {
                    stack.push(left);
                }
            }

            return list;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)


}