package com.zylear.problem.leetcode.editor.en;

//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//
// 
// Related Topics String Dynamic Programming 
// 👍 8748 👎 604


public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("aaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            //dp[n][m]代表以array以n开始m结尾是否是回文数
            boolean dp[][] = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            int max = 1;
//            String string = String.valueOf(s.charAt(0));
            int resultI = 0;
            int resultJ = 0;

            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i < j; i++) {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (i + 1 <= j - 1) {
                        dp[i][j] = dp[i + 1][j - 1] && b;
                    } else {
                        dp[i][j] = b;
                    }
                    if (dp[i][j] && j - i + 1 > max) {
                        max = j - i + 1;
                        resultI = i;
                        resultJ = j;
                    }
                }
            }
            //123432112

            return s.substring(resultI, resultJ + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}