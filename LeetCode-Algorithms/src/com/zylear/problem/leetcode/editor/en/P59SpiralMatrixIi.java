package com.zylear.problem.leetcode.editor.en;

//Given a positive integer n, generate an n x n matrix filled with elements 
//from 1 to n² in spiral order. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics Array Matrix Simulation 👍 5725 👎 236


public class P59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];

            int i = 0;
            int j = 0;
            int minI = 0;
            int minJ = 0;
            int maxI = n - 1;
            int maxJ = n - 1;
            int index = 1;
            while (i <= maxI && i >= minI && j <= maxJ && j >= minJ) {

                while (i <= maxI && i >= minI && j <= maxJ && j >= minJ) {
                    result[i][j]=index++;
                    j++;
                }
                minI++;
                i = minI;
                j = maxJ;

                while (i <= maxI && i >= minI && j <= maxJ && j >= minJ) {
                    result[i][j]=index++;
                    i++;
                }
                maxJ--;
                i = maxI;
                j = maxJ;

                while (i <= maxI && i >= minI && j <= maxJ && j >= minJ) {
                    result[i][j]=index++;
                    j--;
                }
                maxI--;
                i = maxI;
                j = minJ;

                while (i <= maxI && i >= minI && j <= maxJ && j >= minJ) {
                    result[i][j]=index++;
                    i--;
                }
                minJ++;
                i = minI;
                j = minJ;

            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}