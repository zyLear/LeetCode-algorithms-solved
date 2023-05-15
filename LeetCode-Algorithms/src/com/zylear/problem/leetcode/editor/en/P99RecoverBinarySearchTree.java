package com.zylear.problem.leetcode.editor.en;

//You are given the root of a binary search tree (BST), where exactly two nodes 
//of the tree were swapped by mistake. Recover the tree without changing its struc
//ture. 
//
// Follow up: A solution using O(n) space is pretty straight forward. Could you 
//devise a constant space solution? 
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,null,null,2]
//Output: [3,1,null,null,2]
//Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 mak
//es the BST valid.
// 
//
// Example 2: 
//
// 
//Input: root = [3,1,4,null,null,2]
//Output: [2,1,4,null,null,3]
//Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 a
//nd 3 makes the BST valid.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 1000]. 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics Tree Depth-first Search 
// 👍 2105 👎 80


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.Map;

public class P99RecoverBinarySearchTree {
    public static void main(String[] args) {
        // Solution solution = new P99RecoverBinarySearchTree().new Solution();
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


        private TreeNode first;
        private TreeNode second;

        //中序遍历的上一个节点
        private TreeNode prev;


        //中序遍历之后有两个节点是不对的
        // 9 2 2 3 5 1
        //第一个点：大于右边的节点
        //第二个点：小于左边的节点
        public void recoverTree(TreeNode root) {

            doRecoverTree(root);
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        public void doRecoverTree(TreeNode node) {

            if (node == null) {
                return;
            }

            doRecoverTree(node.left);
            //find first
            if (prev != null && prev.val > node.val) {
                if (first == null) {
                    first = prev;
                }
                //第二个位置有两种情况，第一种情况错误节点是连起来的，第二种情况是隔开一个节点以上
                //second节点取最后一个节点就行
                second = node;
            }
            prev = node;
            doRecoverTree(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
