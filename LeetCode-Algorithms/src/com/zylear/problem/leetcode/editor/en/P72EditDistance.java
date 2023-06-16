package com.zylear.problem.leetcode.editor.en;

//Given two strings word1 and word2, return the minimum number of operations 
//required to convert word1 to word2. 
//
// You have the following three operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// 
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
//
// 
// Constraints: 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 and word2 consist of lowercase English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 12753 👎 146


public class P72EditDistance {
    public static void main(String[] args) {
        Solution solution = new P72EditDistance().new Solution();
    }



    /*
Let dp[i][j] be the minimum number of operations required to convert the first i characters of word1 to the first j characters of word2. We will fill up this 2D array from top to bottom and from left to right.

If word1[i-1] == word2[j-1], then no operation is required to convert word1[0:i-1] to word2[0:j-1]. Therefore, dp[i][j] = dp[i-1][j-1].

If word1[i-1] != word2[j-1], then we have three options:

    Replace: Replace the i-th character of word1 with the j-th character of word2. dp[i][j] = dp[i-1][j-1] + 1.

    Delete: Delete the i-th character of word1. dp[i][j] = dp[i-1][j] + 1.

    Insert: Insert the j-th character of word2 into word1. dp[i][j] = dp[i][j-1] + 1.

The final answer will be stored in dp[word1.length()][word2.length()].

    *
    * */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];

            for (int i = 0; i <= word1.length(); i++) {
                dp[i][0] = i;
            }

            for (int j = 0; j <= word2.length(); j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
            }

            return dp[word1.length()][word2.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}