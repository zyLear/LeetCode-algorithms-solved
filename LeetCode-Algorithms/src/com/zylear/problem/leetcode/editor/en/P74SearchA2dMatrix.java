package com.zylear.problem.leetcode.editor.en;

//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 2743 👎 187


public class P74SearchA2dMatrix {
    public static void main(String[] args) {
        // Solution solution = new P74SearchA2dMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {

            int i = matrix.length - 1;
            int j = 0;

            while (i >= 0 && j < matrix[0].length) {
                int num = matrix[i][j];
                if (num == target) {
                    return true;
                }
                if (num > target) {
                    i--;
                } else {
                    j++;
                }
            }
            return false;
        }
        public boolean searchMatrix1(int[][] matrix, int target) {
            int lower = 0;
            int upper = matrix.length - 1;
            while (lower <= upper) {
                int mid = lower + (upper - lower) / 2;
                if (matrix[mid][0] == target) {
                    return true;
                } else if (matrix[mid][0] > target) {
                    upper = mid - 1;
                } else {
                    lower = mid + 1;
                }
            }
            int row = upper;
            if (row < 0) {
                return false;
            }
            lower = 0;
            upper = matrix[0].length - 1;
            while (lower <= upper) {
                int mid = lower + (upper - lower) / 2;
                if (matrix[row][mid] == target) {
                    return true;
                } else if (matrix[row][mid] > target) {
                    upper = mid - 1;
                } else {
                    lower = mid + 1;
                }
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
