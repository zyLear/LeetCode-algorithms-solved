package com.zylear.problem.leetcode.editor.en;

//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return the number of distinct solutions to the n-queens 
//puzzle. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
//
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics Backtracking 👍 3288 👎 242


public class P52NQueensIi {
    public static void main(String[] args) {
        Solution solution = new P52NQueensIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] direction = new int[][]{
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1},
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        int result = 0;
        int size = 0;
        int[][] record;
        public int totalNQueens(int n) {
            record=new int[n][n];
            backtrack(0, n);

            return result;
        }

        private void backtrack(int index, int n) {
            if (size == n) {
                result++;
                return;
            }

            for (int j = 0; j < n; j++) {
                if (meet(index, j)) {
                    size++;
                    record[index][j] = 1;

                    backtrack(index + 1, n);

                    size--;
                    record[index][j] = 0;
                }
            }

        }

        private boolean meet(int i, int j) {
            for (int k = 0; k < direction.length; k++) {
                int newI = i + direction[k][0];
                int newJ = j + direction[k][1];
                while (newI >= 0 && newI < record.length && newJ >= 0 && newJ < record.length) {
                    if (record[newI][newJ] == 1) {
                        return false;
                    }
                    newI = newI + direction[k][0];
                    newJ = newJ + direction[k][1];
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}