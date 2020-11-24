package com.zylear.problem.leetcode.editor.en;

//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lower-case English letters. 
// 
// Related Topics String 
// 👍 3291 👎 2024


public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        String[] strs = {"sdfwww","sdfwer","sdwert"};
        System.out.println(solution.longestCommonPrefix(strs));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null||strs.length == 0 ) {
                return "";
            }
            for (int index = 0; index < strs[0].length(); index++) {
                char temp = strs[0].charAt(index);
                for (int i = 1; i < strs.length; i++) {
                    if (index >= strs[i].length()
                            ||strs[i].charAt(index) != temp) {
                        return strs[0].substring(0, index);
                    }
                }
            }
            return strs[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

