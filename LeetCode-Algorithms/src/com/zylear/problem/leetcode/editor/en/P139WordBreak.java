package com.zylear.problem.leetcode.editor.en;

//Given a string s and a dictionary of strings wordDict, return true if s can be
// segmented into a space-separated sequence of one or more dictionary words. 
//
// Note that the same word in the dictionary may be reused multiple times in the
// segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pe
//n apple".
//Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
// Related Topics Dynamic Programming 
// 👍 6355 👎 301


import java.util.Arrays;
import java.util.List;

public class P139WordBreak {
    public static void main(String[] args) {
        Solution solution = new P139WordBreak().new Solution();
        System.out.println(solution.wordBreak("lee", Arrays.asList("le", "e")));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.isEmpty()) {
                return true;
            }

            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                boolean result = false;
                for (int j = 1; j <= i; j++) {
                    if (dp[j - 1] && judge(s, wordDict, j - 1, i)) {
                        result = true;
                        break;
                    }
                }
                dp[i] = result;
            }

            return dp[s.length()];
        }

        public boolean judge(String s, List<String> wordDict, int start, int end) {
            String substring = s.substring(start, end);
            for (String string : wordDict) {
                if (string.equals(substring)) {
                    return true;
                }
            }
            return false;
        }

        //暴力法  时间超时
        public boolean wordBreak1(String s, List<String> wordDict) {

            if (s.isEmpty()) {
                return true;
            }
            for (String string : wordDict) {
                if (s.startsWith(string)) {
                    if (wordBreak1(s.substring(string.length()), wordDict)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
