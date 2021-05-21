package com.zylear.problem.leetcode.editor.en;

//Given an m x n binary matrix filled with 0's and 1's, find the largest square 
//containing only 1's and return its area. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: matrix = [["0","1"],["1","0"]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] is '0' or '1'. 
// 
// Related Topics Dynamic Programming 
// 👍 4628 👎 108


import java.util.Arrays;

public class P221MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new P221MaximalSquare().new Solution();
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        solution.maximalSquare(matrix);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        //可以用暴力法 遍历棋盘，遍历的点作为矩阵的左上角的点判断最大矩阵
        public int maximalSquare1(char[][] matrix) {

            int result = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {

                    if (matrix[i][j] == '1') {

                        int count = calculateSquare(matrix, i, j);
                        result = Math.max(result, count);

                    }

                }
            }

            return result * result;
        }

        private int calculateSquare(char[][] matrix, int iIndex, int jIndex) {

            int count = 1;
            loop:
            while (count + iIndex < matrix.length && count + jIndex < matrix[0].length) {

                int i = count + iIndex;
                int j = count + jIndex;
                for (int k = iIndex; k <= i; k++) {
                    if (matrix[k][j] != '1') {
                        break loop;
                    }
                }

                for (int k = jIndex; k <= j; k++) {
                    if (matrix[i][k] != '1') {
                        break loop;
                    }
                }

                count++;
            }

            return count;
        }


        //动态规划
        //dp[i][j] 表示从零点到matrix[i][j]并且包括点（i,j)的最大矩阵
        public int maximalSquare(char[][] matrix) {

            int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
            int result = 0;

            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <= matrix[0].length; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }


            return result * result;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)

}
