package com.zylear.problem.leetcode.editor.en;

//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [["Q"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
// Related Topics Backtracking 
// 👍 2469 👎 95


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P51NQueens {
    public static void main(String[] args) {
        // Solution solution = new P51NQueens().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<String>> result = new LinkedList<>();
        int[][] record;
        int size = 0;

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

        public List<List<String>> solveNQueens(int n) {
            record = new int[n][n];
            backtracking(0, n);
            return result;
        }

        private void backtracking(int index, int n) {
            if (size == n) {
                result.add(formResult());
                return;
            }

            for (int j = 0; j < n; j++) {
                if (meet(index, j)) {
                    record[index][j] = 1;
                    size++;
                    backtracking(index + 1, n);
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

        private List<String> formResult() {
            List<String> list = new ArrayList<>(record.length);
            for (int i = 0; i < record.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < record.length; j++) {
                    if (record[i][j] == 1) {
                        stringBuilder.append("Q");
                    } else {
                        stringBuilder.append(".");
                    }
                }
                list.add(stringBuilder.toString());
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
