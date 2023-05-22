package com.zylear.problem.leetcode.editor.en;

//Given inorder and postorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics Array Tree Depth-first Search 
// 👍 2217 👎 42


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
        }


        //根据前序遍历后序遍历找到 中间节点
        //在中序数组中找到中间节点的坐标，计算左右子树的长度，递归构建

        public TreeNode buildTree(int[] postorder, int postOrderStart, int postOrderEnd, int[] inorder, int inOrderStart, int inOrderEnd) {
            if (postOrderStart > postOrderEnd) {
                return null;
            }
            TreeNode treeNode = new TreeNode();
            treeNode.val = postorder[postOrderEnd];
            int inOrderListMidIndex = findIndex(inorder, treeNode.val, inOrderStart, inOrderEnd);
            int leftLength = inOrderListMidIndex - inOrderStart;
            int rightLength = inOrderEnd - inOrderListMidIndex;
            treeNode.left = buildTree(postorder, postOrderStart, postOrderStart + leftLength - 1, inorder, inOrderStart, inOrderListMidIndex - 1);
            treeNode.right = buildTree(postorder, postOrderStart + leftLength, postOrderEnd - 1, inorder, inOrderListMidIndex + 1, inOrderEnd);
            return treeNode;
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