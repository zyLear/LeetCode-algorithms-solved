package com.zylear.problem.leetcode.editor.en;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// Now consider if some obstacles are added to the grids. How many unique paths 
//would there be? 
//
// An obstacle and space is marked as 1 and 0 respectively in the grid. 
//
// 
// Example 1: 
//
// 
//Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//Output: 2
//Explanation: There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
// 
//
// Example 2: 
//
// 
//Input: obstacleGrid = [[0,1],[0,0]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] is 0 or 1. 
// 
// Related Topics Array Dynamic Programming 
// 👍 2227 👎 267


public class P63UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new P63UniquePathsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m + 1][n + 1];
            dp[1][1] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (obstacleGrid[i - 1][j - 1] == 1) {
                        dp[i][j] = 0;
                    }else{
                        if (dp[i][j] == 0) {
                            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                        }
                    }
                }
            }


            return dp[m][n];

        }
        public int uniquePathsWithObstacles1(int[][] obstacleGrid) {



            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            //判断结束位置是否有障碍
            if (obstacleGrid[m - 1][n - 1] == 1) {
                return 0;
            }

            //判断开始位置是否有障碍
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }

            int[][] dp = new int[m + 2][n + 2];

            //设置障碍
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i + 1][j + 1] = -1;
                    }
                }
            }
            dp[m][n] = 1;
            for (int i = m; i > 0; i--) {
                for (int j = n; j > 0; j--) {
                    //判断不是障碍和目标位置
                    if ((i != m || j != n) && dp[i][j] != -1) {
                        dp[i][j] = (dp[i + 1][j] == -1 ? 0 : dp[i + 1][j]) +
                                (dp[i][j + 1] == -1 ? 0 : dp[i][j + 1]);
                    }
                }

            }

            return dp[1][1];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}