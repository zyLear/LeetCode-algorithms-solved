package com.zylear.problem.leetcode.editor.en;

//Given a binary tree containing digits from 0-9 only, each root-to-leaf path co
//uld represent a number. 
//
// An example is the root-to-leaf path 1->2->3 which represents the number 123. 
//
//
// Find the total sum of all root-to-leaf numbers. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input: [1,2,3]
//    1
//   / \
//  2   3
//Output: 25
//Explanation:
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Therefore, sum = 12 + 13 = 25. 
//
// Example 2: 
//
// 
//Input: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//Output: 1026
//Explanation:
//The root-to-leaf path 4->9->5 represents the number 495.
//The root-to-leaf path 4->9->1 represents the number 491.
//The root-to-leaf path 4->0 represents the number 40.
//Therefore, sum = 495 + 491 + 40 = 1026. 
// Related Topics Tree Depth-first Search 
// 👍 1899 👎 46


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.Stack;

public class P129SumRootToLeafNumbers {
    public static void main(String[] args) {
        // Solution solution = new P129SumRootToLeafNumbers().new Solution();
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
        private Integer result = 0;
        public int sumNumbers(TreeNode root) {
            inorderTree(root);
            return result;
        }

        public void inorderTree(TreeNode node) {
            if (node != null) {

                stack.push(node.val);

                inorderTree(node.left);

                if (node.left == null && node.right == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Integer integer : stack) {
                        stringBuilder.append(integer);
                    }
                    result += Integer.parseInt(stringBuilder.toString());
                }

                inorderTree(node.right);

                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
