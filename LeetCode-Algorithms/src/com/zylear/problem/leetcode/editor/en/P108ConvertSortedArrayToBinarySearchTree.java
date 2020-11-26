package com.zylear.problem.leetcode.editor.en;

//Given an array where elements are sorted in ascending order, convert it to a h
//eight balanced BST. 
//
// For this problem, a height-balanced binary tree is defined as a binary tree i
//n which the depth of the two subtrees of every node never differ by more than 1.
// 
//
// Example: 
//
// 
//Given the sorted array: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following he
//ight balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics Tree Depth-first Search 
// 👍 3119 👎 238


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        // Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();
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
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums.length==0){
                return null;
            }
            return sortedArrayToBST(nums, 0, nums.length-1);
        }

        public TreeNode sortedArrayToBST(int[] nums, int lower, int upper) {

            if(lower <= upper){

                int mid = lower + ((upper-lower)/2);
                TreeNode node = new TreeNode();
                node.val=nums[mid];
                node.left=sortedArrayToBST(nums, lower, mid-1);
                node.right=sortedArrayToBST(nums, mid+1, upper);
                return node;
            }

            return null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
