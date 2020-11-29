package com.zylear.problem.leetcode.editor.en;

//Given an integer n, generate all structurally unique BST's (binary search tree
//s) that store values 1 ... n. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//Explanation:
//The above output corresponds to the 5 unique BST's shown below:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 8 
// 
// Related Topics Dynamic Programming Tree 
// 👍 2648 👎 188


import com.zylear.problem.leetcode.editor.en.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new P95UniqueBinarySearchTreesIi().new Solution();
        System.out.println(solution.generateTrees(2));
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

        public List[] dp;
        public List<TreeNode> empty = Collections.singletonList(null);

        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return Collections.emptyList();
            }
            dp = new List[n + 1];

            dp[0] = empty;

            for (int i = 1; i <= n; i++) {
                List<TreeNode> list = new ArrayList<>();
                for (int j = 1; j <= i; j++) {

                    List leftList = dp[j - 1] == null ? empty : dp[j - 1];
                    List rightList = generateOffset((List<TreeNode>) dp[i - j], j);

                    for (TreeNode leftNode : (List<TreeNode>) leftList) {
                        for (TreeNode rightNode : (List<TreeNode>) rightList) {
                            TreeNode treeNode = new TreeNode();
                            treeNode.val = j;
                            treeNode.left = leftNode;
                            treeNode.right = rightNode;
                            list.add(treeNode);
                        }
                    }
                }
                dp[i] = list;
            }

            return dp[n];
        }

        private List generateOffset(List<TreeNode> list, int offset) {
            if (list == null) {
                return empty;
            }
//            if (offset == 0) {
//                return list;
//            }

            List<TreeNode> result = new ArrayList<>();
            for (TreeNode treeNode : list) {
                result.add(cloneOffset(treeNode, offset));
            }
            return result;
        }

        private TreeNode cloneOffset(TreeNode treeNode, int offset) {

            if (treeNode == null) {
                return null;
            }else {
                TreeNode node = new TreeNode();
                node.val = treeNode.val + offset;
                node.left = cloneOffset(treeNode.left, offset);
                node.right = cloneOffset(treeNode.right, offset);
                return node;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}