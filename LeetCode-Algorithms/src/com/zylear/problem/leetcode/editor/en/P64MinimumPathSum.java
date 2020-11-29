package com.zylear.problem.leetcode.editor.en;

//Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right, which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// 
//
// Example 2: 
//
// 
//Input: grid = [[1,2,3],[4,5,6]]
//Output: 12
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics Array Dynamic Programming 
// 👍 3867 👎 76


public class P64MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new P64MinimumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length == 0) {
                return 0;
            }

            int m = grid.length;
            int n = grid[0].length;

            int[][] dp = new int[m + 2][n + 2];
            dp[m][n] = grid[m - 1][n - 1];

            for (int i = 0; i < m + 2; i++) {
                dp[i][0] = Integer.MAX_VALUE;
                dp[i][n + 1] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < n + 2; i++) {
                dp[0][i] = Integer.MAX_VALUE;
                dp[m + 1][i] = Integer.MAX_VALUE;
            }

            for (int i = m; i > 0; i--) {
                for (int j = n; j > 0; j--) {
                    if (i != m || j != n) {
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i - 1][j - 1];
                    }
                }
            }


            return dp[1][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}