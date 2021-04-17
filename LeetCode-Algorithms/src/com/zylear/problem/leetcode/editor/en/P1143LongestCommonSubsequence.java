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
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int max = 0;

//            if (text1.length() < text2.length()) {
//                String temp = text1;
//                text2 = text1;
//                text1 = temp;
//            }

//            for (int i = 0; i < text1.length() + text2.length(); i++) {
//
//                int count = 0;
//                for (int r = i - text2.length(), t = 0; r >= 0 && r < text1.length() && t < text2.length(); r++, t++) {
//                    if (text1.charAt(r) == text2.charAt(t)) {
//                        count++;
//                    } else {
//                        max = Math.max(count, max);
//                        count = 0;
//                    }
//                }
//                max = Math.max(count, max);
//            }
//            return max;
            return 0;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}