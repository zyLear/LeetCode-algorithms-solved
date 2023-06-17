package com.zylear.problem.leetcode.editor.en;

//Given an m x n matrix board containing 'X' and 'O', capture all regions that 
//are 4-directionally surrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded 
//region. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X",
//"O","X","X"]]
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X",
//"X"]]
//Explanation: Notice that an 'O' should not be flipped if:
//- It is on the border, or
//- It is adjacent to an 'O' that should not be flipped.
//The bottom 'O' is on the border, so it is not flipped.
//The other three 'O' form a surrounded region, so they are flipped.
// 
//
// Example 2: 
//
// 
//Input: board = [["X"]]
//Output: [["X"]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] is 'X' or 'O'. 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 7246 👎 1539


public class P130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {

            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == 'O') {
                    dfs(i, 0, board);
                }
                if (board[i][board[0].length - 1] == 'O') {
                    dfs(i, board[0].length - 1, board);
                }
            }

            for (int j = 0; j < board[0].length; j++) {
                if (board[0][j] == 'O') {
                    dfs(0, j, board);
                }
                if (board[board.length - 1][j] == 'O') {
                    dfs(board.length - 1, j, board);
                }
            }

            swap(board, 'O', 'X');
            swap(board, '#', 'O');
        }

        private void swap(char[][] board, char c, char o) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == c) {
                        board[i][j] = o;
                    }
                }
            }
        }

        private void dfs(int i, int j, char[][] board) {
            if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                if (board[i][j] == 'O') {
                    board[i][j] = '#';
                    dfs(i - 1, j, board);
                    dfs(i + 1, j, board);
                    dfs(i, j + 1, board);
                    dfs(i, j - 1, board);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}