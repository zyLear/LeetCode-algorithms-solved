package com.zylear.problem.leetcode.editor.en;

//A message containing letters from A-Z is being encoded to numbers using the fo
//llowing mapping: 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// Given a non-empty string containing only digits, determine the total number o
//f ways to decode it. 
//
// The answer is guaranteed to fit in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: s = "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
//.
// 
//
// Example 3: 
//
// 
//Input: s = "0"
//Output: 0
//Explanation: There is no character that is mapped to a number starting with '0
//'. We cannot ignore a zero when we face it while decoding. So, each '0' should b
//e part of "10" --> 'J' or "20" --> 'T'.
//
//
// Example 4: 
//
// 
//Input: s = "1"
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only digits and may contain leading zero(s). 
// 
// Related Topics String Dynamic Programming 
// 👍 3476 👎 3236


public class P91DecodeWays {
    public static void main(String[] args) {
        Solution solution = new P91DecodeWays().new Solution();
        System.out.println(solution.numDecodings("2101"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            if (s.charAt(0) == '0') {
                return 0;
            }

            int[][] dp = new int[s.length()][s.length()];

            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }

            for (int j = 1; j < s.length(); j++) {
                for (int i = 0; i < j; i++) {


                    int intOne = (int) s.charAt(j - 1) - '0';
                    int intTwo = (int) s.charAt(j) - '0';
                    int sum = intOne * 10 + intTwo;

                    if (intOne == 0 && intTwo == 0) {
                        return dp[i][j] = 0;
                    } else if (intOne != 0 && intTwo == 0) {
                        if (sum >= 10 && sum <= 26) {
                            dp[i][j] = (j - 2 >= 0 ? dp[i][j - 2] : 1);
                        } else if (sum > 26) {
                            dp[i][j] = 0;
                        }
                    } else if (intOne == 0 && intTwo != 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        if (sum >= 10 && sum <= 26) {
                            dp[i][j] = dp[i][j - 1] + (j - 2 >= 0 ? dp[i][j - 2] : 1);
                        } else if (sum > 26) {
                            dp[i][j] = dp[i][j - 1];
                        }
                    }

                }
            }
            return dp[0][s.length() - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}