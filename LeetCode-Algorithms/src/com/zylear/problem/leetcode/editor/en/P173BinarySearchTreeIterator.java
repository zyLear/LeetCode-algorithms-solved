package com.zylear.problem.leetcode.editor.en;

//Implement an iterator over a binary search tree (BST). Your iterator will be i
//nitialized with the root node of a BST. 
//
// Calling next() will return the next smallest number in the BST. 
//
// 
//
// 
// 
//
// Example: 
//
// 
//
// 
//BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // return 3
//iterator.next();    // return 7
//iterator.hasNext(); // return true
//iterator.next();    // return 9
//iterator.hasNext(); // return true
//iterator.next();    // return 15
//iterator.hasNext(); // return true
//iterator.next();    // return 20
//iterator.hasNext(); // return false
// 
//
// 
//
// Note: 
//
// 
// next() and hasNext() should run in average O(1) time and uses O(h) memory, wh
//ere h is the height of the tree. 
// You may assume that next() call will always be valid, that is, there will be
//at least a next smallest number in the BST when next() is called.
// 
// Related Topics Stack Tree Design 
// 👍 3048 👎 287


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P173BinarySearchTreeIterator {
    public static void main(String[] args) {
//        Solution solution = new P173BinarySearchTreeIterator().new Solution();
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
    class BSTIterator {


        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            putLeftNode(root);
//            return value;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = stack.pop();
            int value = node.val;
            putLeftNode(node.right);
            return value;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public void putLeftNode(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
//leetcode submit region end(Prohibit modification and deletion)


    class BSTIterator2 {


        private Stack<TreeNode> stack = new Stack<>();
        private Queue<Integer> result = new LinkedList<>();

        public BSTIterator2(TreeNode root) {
            putLeftNode(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                int value = node.val;
                result.add(value);
                putLeftNode(node.right);
            }


//            return value;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return result.remove();
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !result.isEmpty();
        }

        public void putLeftNode(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

    }


}