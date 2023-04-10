package com.zylear.problem.leetcode.editor.en;

//Given the root of a binary tree, return the sum of all left leaves. 
//
// A leaf is a node with no children. A left leaf is a leaf that is the left 
//child of another node. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 24
//Explanation: There are two left leaves in the binary tree, with values 9 and 1
//5 respectively.
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 44
//37 👎 276


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P404SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new P404SumOfLeftLeaves().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int count = 0;
    public int sumOfLeftLeaves1(TreeNode root) {

        if (root == null) {
            return count;
        }

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                count += root.left.val;
            }
        }
        sumOfLeftLeaves1(root.left);
        sumOfLeftLeaves1(root.right);


        return count;
    }

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}