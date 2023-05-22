package com.zylear.problem.leetcode.editor.en;

//Given n, how many structurally unique BST's (binary search trees) that store v
//alues 1 ... n?
//
// Example: 
//
// 
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
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
// 1 <= n <= 19 
// 
// Related Topics Dynamic Programming Tree 
// 👍 4032 👎 147


public class P96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int count = 0;

        public int[][] lowDp;

        //表示n个节点有多少中可能
        public int[] dp;


        public int numTrees(int n) {
            dp = new int[n + 1];

            dp[0] = 1;
//
            for (int i = 1; i <= n; i++) {

                for (int j = 1; j <= i; j++) {
                    //j代表以j为跟节点
                    //j-1 代表左边节点的长度
                    //i-j 代表右边节点的长度
                    dp[i] = dp[i] + (dp[j - 1] * dp[i - j]);
                }

            }
            return dp[n];
        }

        //暴力求解  保存中间计算结果 时间就不超时了
        public int numTrees(int start, int end) {

            if (end < start) {
                return 1;
            }

            if (lowDp[start][end] != 0) {
                return lowDp[start][end];
            }

            int count = 0;
            for (int i = start; i <= end; i++) {
                int leftCount = numTrees(start, i - 1);
                int rightCount = numTrees(i + 1, end);
                count = count + (leftCount * rightCount);
            }

            lowDp[start][end] = count;

            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}