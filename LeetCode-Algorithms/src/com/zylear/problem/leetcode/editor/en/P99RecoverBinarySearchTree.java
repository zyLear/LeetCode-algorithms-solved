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


        public void recoverTree(TreeNode root) {

            recoverTree(root, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE));
        }

        public boolean recoverTree(TreeNode node, TreeNode min, TreeNode max) {
            if (node != null) {
                if (node.val < min.val) {
                    int temp = node.val;
                    node.val = min.val;
                    min.val = temp;
                    System.out.println("mm");
                    return true;
                } else if (node.val > max.val) {
                    int temp = node.val;
                    node.val = max.val;
                    max.val = temp;
                    System.out.println("aa");
                    System.out.println(node.val);
                    System.out.println(max.val);
                    return true;
                }


                return recoverTree(node.left, min, node)
                        || recoverTree(node.right, node, max);
            }
            return false;
        }

//        public boolean recoverTree(TreeNode node, TreeNode max, TreeNode min, boolean isLeft) {
//            if (node != null) {
//                if (node.right != null && node.right.val < min.val) {
//                    int temp = node.right.val;
//                    node.right.val = min.val;
//                    min.val = temp;
//                    System.out.println("aa");
//                    return true;
//                } else if (node.left != null && node.left.val > max.val) {
//                    int temp = node.left.val;
//                    node.left.val = max.val;
//                    max.val = temp;
//                    System.out.println("aa");
//                    return true;
//                }
//                if (isLeft) {
//                     max = max.val > node.val ? max : node;
//                } else {
//                    minNode = min.val < node.val ? min : node;
//                }
//
//                boolean a = recoverTree(node.left, max, min, true);
//                if (a) {
//                    return true;
//                }
//                return recoverTree(node.right, max, min, false);
//            }
//            return false;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
