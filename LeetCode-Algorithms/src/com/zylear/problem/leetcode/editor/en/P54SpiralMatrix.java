package com.zylear.problem.leetcode.editor.en;

//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics Array Matrix Simulation 👍 12368 👎 1108


import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>(matrix.length * matrix.length);

        int i = 0;
        int j = 0;
        int minI = 0;
        int minJ = 0;
        int maxI = matrix.length - 1;
        int maxJ = matrix[0].length- 1;
        while (i <= maxI && i >= minI && j <= maxJ && j >= minJ){

            while (i <= maxI && i >= minI && j <= maxJ && j >= minJ) {
                result.add(matrix[i][j]);
                j++;
            }
            minI++;
            i = minI;
            j = maxJ;

            while (i <= maxI && i >= minI && j <= maxJ && j >= minJ) {
                result.add(matrix[i][j]);
                i++;
            }
            maxJ--;
            i = maxI;
            j = maxJ;

            while (i <= maxI && i >= minI && j <= maxJ && j >= minJ) {
                result.add(matrix[i][j]);
                j--;
            }
            maxI--;
            i = maxI;
            j = minJ;

            while (i <= maxI && i >= minI && j <= maxJ && j >= minJ) {
                result.add(matrix[i][j]);
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