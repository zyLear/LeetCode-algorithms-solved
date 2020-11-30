package com.zylear.problem.leetcode.editor.en;

//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings are isomorphic if the characters in s can be replaced to get t. 
//
// All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may map to the same charac
//ter but a character may map to itself. 
//
// Example 1: 
//
// 
//Input: s = "egg", t = "add"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "foo", t = "bar"
//Output: false 
//
// Example 3: 
//
// 
//Input: s = "paper", t = "title"
//Output: true 
//
// Note: 
//You may assume both s and t have the same length. 
// Related Topics Hash Table 
// 👍 1678 👎 413


import java.util.HashMap;
import java.util.Map;

public class P205IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
        System.out.println(solution.isIsomorphic("ab", "aa"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s == null && t == null) {
                return true;
            } else if (s == null || t == null) {
                return false;
            } else if (s.length() != t.length()) {
                return false;
            }

            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> reverseMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Integer integer = map.get((int) s.charAt(i));
                if (integer == null) {
                    Integer integer2 = reverseMap.get((int) t.charAt(i));
                    if (integer2 == null) {
                        map.put((int) s.charAt(i), (int) t.charAt(i));
                        reverseMap.put((int) t.charAt(i), (int) s.charAt(i));
                    } else {
                        return false;
                    }
                } else {
                    if ((int) t.charAt(i) != integer) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
