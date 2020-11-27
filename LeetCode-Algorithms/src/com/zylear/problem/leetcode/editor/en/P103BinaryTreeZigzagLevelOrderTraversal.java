package com.zylear.problem.leetcode.editor.en;

//Given a binary tree, return the zigzag level order traversal of its nodes' val
//ues. (ie, from left to right, then right to left for the next level and alternat
//e between). 
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
//return its zigzag level order traversal as: 
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics Stack Tree Breadth-first Search 
// 👍 2785 👎 112


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> result = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int count = 0;
            while (!queue.isEmpty()) {

                count++;
                int size = queue.size();
                LinkedList<Integer> levelList = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (count % 2 == 1) {
                        levelList.add(node.val);
                    }else {
                        levelList.addFirst(node.val);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                result.add(levelList);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}