package com.zylear.problem.leetcode.editor.en;

//Given an m x n board and a word, find if the word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, wher
//e "adjacent" cells are horizontally or vertically neighboring. The same letter c
//ell may not be used more than once. 
//
// 
// Example 1: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 200 
// 1 <= word.length <= 103 
// board and word consists only of lowercase and uppercase English letters. 
// 
// Related Topics Array Backtracking 
// 👍 4913 👎 215


public class P79WordSearch {
    public static void main(String[] args) {
        // Solution solution = new P79WordSearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            char c = word.charAt(0);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == c) {
                        board[i][j] = '#';
                        if (backtrack(i, j, 1, board, word)) {
                            return true;
                        }
                        board[i][j] = c;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(int i, int j, int index, char[][] board, String word) {
            if (index == word.length()) {
                return true;
            }
            char c = word.charAt(index);


            if (!outBound(i - 1, j, board) && c == board[i - 1][j]) {
                board[i - 1][j] = '#';
                if (backtrack(i - 1, j, index + 1, board, word)) {
                    return true;
                }
                board[i - 1][j] = c;
            }

            if (!outBound(i + 1, j, board) && c == board[i + 1][j]) {
                board[i + 1][j] = '#';
                if (backtrack(i + 1, j, index + 1, board, word)) {
                    return true;
                }
                board[i + 1][j] = c;
            }

            if (!outBound(i, j - 1, board) && c == board[i][j - 1]) {
                board[i][j - 1] = '#';
                if (backtrack(i, j - 1, index + 1, board, word)) {
                    return true;
                }
                board[i][j - 1] = c;
            }

            if (!outBound(i, j + 1, board) && c == board[i][j + 1]) {
                board[i][j + 1] = '#';
                if (backtrack(i, j + 1, index + 1, board, word)) {
                    return true;
                }
                board[i][j + 1] = c;
            }

            return false;
        }

        private boolean outBound(int i, int j, char[][] board) {
            if (i >= 0 && i < board.length &&
                    j >= 0 && j < board[0].length) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
