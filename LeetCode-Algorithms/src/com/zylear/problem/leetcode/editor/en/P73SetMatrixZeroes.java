package com.zylear.problem.leetcode.editor.en;

//Given an m x n integer matrix matrix, if an element is 0, set its entire row 
//and column to 0's. 
//
// You must do it in place. 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -2³¹ <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
// Follow up: 
//
// 
// A straightforward solution using O(mn) space is probably a bad idea. 
// A simple improvement uses O(m + n) space, but still not the best solution. 
// Could you devise a constant space solution? 
// 
//
// Related Topics Array Hash Table Matrix 👍 11771 👎 629


import java.util.Arrays;

public class P73SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new P73SetMatrixZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {

            boolean firstRowZero = false;
            boolean firstColumnZero = false;


            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        if (i == 0) {
                            firstRowZero = true;
                        }
                        if (j == 0) {
                            firstColumnZero = true;
                        }
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }

            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if(firstRowZero) {
                Arrays.fill(matrix[0], 0);
            }
            if(firstColumnZero) {
                for(int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}