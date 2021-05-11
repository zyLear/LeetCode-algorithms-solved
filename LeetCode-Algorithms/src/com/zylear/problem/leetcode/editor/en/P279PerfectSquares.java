package com.zylear.problem.leetcode.editor.en;

//Given an integer n, return the least number of perfect square numbers that sum
// to n. 
//
// A perfect square is an integer that is the square of an integer; in other wor
//ds, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 104 
// 
// Related Topics Math Dynamic Programming Breadth-first Search 
// 👍 4362 👎 237


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P279PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new P279PerfectSquares().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {

            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);


            for (int i = 0; i * i <= n; i++) {
                dp[i * i] = 1;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; i + j * j <= n; j++) {
                    dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
                }
            }

//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j < i; j++) {
//                    dp[i] = Math.min(dp[i - j] + dp[j], dp[i]);
//                }
//            }

            return dp[n];

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}