package com.zylear.problem.leetcode.editor.en;

//Given the root of a binary tree, return the postorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [3,2,1]
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
//Output: [2,1]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree is in the range [0, 100]. 
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
// 👍 2186 👎 107


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.*;

public class P145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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

        private LinkedList<Integer> list = new LinkedList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            if (root != null) {
                postorderTraversal(root.left);
                postorderTraversal(root.right);
                list.add(root.val);
            }
            return list;
        }

        public List<Integer> postorderTraversal3(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            LinkedList<Integer> list = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.addFirst(node.val);

                TreeNode left = node.left;
                if (left != null) {
                    stack.push(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    stack.push(right);
                }
            }

            return list;
        }


        public List<Integer> postorderTraversal1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            putLeftSize(root, stack);
            //记录上一次遍历的节点  给中间节点判断
            TreeNode lastVisit = null;
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.right == null || node.right == lastVisit) {
                    list.add(node.val);
                    lastVisit = node;
                } else {
                    //再放进去 很重要
                    stack.push(node);
                    putLeftSize(node.right, stack);
                }
            }

            return list;
        }

        public void putLeftSize(TreeNode node, Stack<TreeNode> stack) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}