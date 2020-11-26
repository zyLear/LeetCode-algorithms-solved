package com.zylear.problem.leetcode.editor.en;

//Given a binary tree, return the bottom-up level order traversal of its nodes' 
//values. (ie, from left to right, level by level from leaf to root). 
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
//return its bottom-up level order traversal as: 
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics Tree Breadth-first Search 
// 👍 1796 👎 229


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.*;

public class P107BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;

        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 2;
        treeNode.left = treeNode2;

        System.out.println(solution.levelOrderBottom(treeNode));
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<List<Integer>> result = new LinkedList<>();

            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);


            while (!queue.isEmpty()) {
                List<Integer> levelList = new ArrayList<>();

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();

                    levelList.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

                if (!levelList.isEmpty()) {
                    result.addFirst(levelList);
                }
            }


            return result;


        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();

            LinkedList<List<Integer>> result = new LinkedList<>();


            result.add(Collections.singletonList(root.val));
            queue.add(root);

            while (!queue.isEmpty()) {
                List<Integer> currentLevel = new LinkedList<>();

                while (!queue.isEmpty()) {

                    TreeNode node = queue.poll();

                    if (node.left != null) {
                        tempQueue.add(node.left);
                        currentLevel.add(node.left.val);
                    }

                    if (node.right != null) {
                        tempQueue.add(node.right);
                        currentLevel.add(node.right.val);
                    }
                }
                if (!currentLevel.isEmpty()) {
                    System.out.println(currentLevel);
                    result.addFirst(currentLevel);
                }

                currentLevel = new LinkedList<>();
                while (!tempQueue.isEmpty()) {
                    TreeNode node = tempQueue.poll();

                    if (node.left != null) {
                        queue.add(node.left);
                        currentLevel.add(node.left.val);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                        currentLevel.add(node.right.val);
                    }
                }

                if (!currentLevel.isEmpty()) {
                    result.addFirst(currentLevel);
                }

            }

            return result;

        }
    }
}

