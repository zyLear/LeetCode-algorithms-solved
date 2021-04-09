package com.zylear.problem.leetcode.editor.en;

//Given a string s, partition s such that every substring of the partition is a 
//palindrome. 
//
// Return the minimum cuts needed for a palindrome partitioning of s. 
//
// 
// Example 1: 
//
// 
//Input: s = "aab"
//Output: 1
//Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 
//cut.
// 
//
// Example 2: 
//
// 
//Input: s = "a"
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: s = "ab"
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2000 
// s consists of lower-case English letters only. 
// 
// Related Topics Dynamic Programming 
// 👍 1762 👎 52


import java.util.Arrays;

public class P132PalindromePartitioningIi {
    public static void main(String[] args) {
        // Solution solution = new P132PalindromePartitioningIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int[] dp = new int[s.length() + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= i; j++) {
                    if (j == 1) {
                        String substring = s.substring(j - 1, i);
                        if (judge(substring)) {
                            dp[i] = 1;
                            break;
                        }
                    } else {
                        String substring = s.substring(j - 1, i);
                        if (dp[j - 1] != Integer.MAX_VALUE && judge(substring)) {
                            dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
                        }
                    }
                }
            }
            return dp[s.length()] - 1;
        }

        private boolean judge(String substring) {
            int i = 0;
            int j = substring.length() - 1;
            while (i < j) {
                if (substring.charAt(i) != substring.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
