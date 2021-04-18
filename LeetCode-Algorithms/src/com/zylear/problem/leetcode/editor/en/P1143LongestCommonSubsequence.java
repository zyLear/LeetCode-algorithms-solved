package com.zylear.problem.leetcode.editor.en;

//Given two strings text1 and text2, return the length of their longest common s
//ubsequence. If there is no common subsequence, return 0. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order o
//f the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// A common subsequence of two strings is a subsequence that is common to both s
//trings. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 and text2 consist of only lowercase English characters. 
// 
// Related Topics Dynamic Programming 
// 👍 2859 👎 36


public class P1143LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new P1143LongestCommonSubsequence().new Solution();
        System.out.println(solution.longestCommonSubsequence("abc", "ac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int max = 0;

            //总结 如果解不要求连续，则dp[n]的设定就不用是以array[n]结尾的解
            //dp[i][j] 表示text1[i] text2[j]字符串的解
            //所以最终的解是dp[text1.length()][text2.length()]
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];

            for (int i = 1; i <= text1.length(); i++) {
                for (int j = 1; j <= text2.length(); j++) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    }
                }
            }

            return dp[text1.length()][text2.length()];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}