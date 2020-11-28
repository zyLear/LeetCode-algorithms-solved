package com.zylear.problem.leetcode.editor.en;

//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics Array Tree Depth-first Search 
// 👍 4274 👎 112


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] a = {9, 3, 15, 20, 7};
        solution.findIndex(a, 3, 0, 4);
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

//        private Map<Integer, Integer> indexMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
//            for (int i = 0; i < inorder.length; i++) {
//                indexMap.put(inorder[i], i);
//            }
            return buildTree(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);

        }

        public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd) {
                return null;
            } else {

                TreeNode node = new TreeNode();
                node.val = preorder[preStart];
                int index = findIndex(inorder, node.val, inStart, inEnd);

                int leftLength = index - inStart;
//                int rightLength = inEnd - index;
                node.left = buildTree(preorder, preStart + 1, preStart + leftLength, inorder, inStart, index - 1);
                node.right = buildTree(preorder, preStart + leftLength + 1, preEnd, inorder, index + 1, inEnd);

                return node;
            }
        }

        public int findIndex(int[] array, int value, int start, int end) {
            //没说明是排序树！！！   不能用二分搜索
//            return indexMap.get(value);
            for (int i = start; i <= end; i++) {
                if (array[i] == value) {
                    return i;
                }
            }
//
            return start;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)


}