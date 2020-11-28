package com.zylear.problem.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

//Given two strings s and t,write a function to determine if t is an anagram o
//f s.
//
// Example 1: 
//
// 
//Input: s = "anagram", t = "nagaram"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "rat", t = "car"
//Output: false
// 
//
// Note: 
//You may assume the string contains only lowercase alphabets. 
//
// Follow up: 
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case? 
// Related Topics Hash Table Sort 
// 👍 1973 👎 155


public class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null && t == null) {
                return true;
            } else if (s == null || t == null) {
                return false;
            }

            if (s.length() != t.length()) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Integer count = map.get((int) s.charAt(i));
                if (count == null) {
                    count = 0;
                }
                map.put((int) s.charAt(i), count + 1);
            }


            for (int i = 0; i < t.length(); i++) {
                Integer count = map.get((int) t.charAt(i));
                if (count == null) {
                    return false;
                } else {
                    count--;
                    if (count == 0) {
                        map.remove((int) t.charAt(i));
                    } else {
                        map.put((int) t.charAt(i), count);
                    }
                }
            }
            return map.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}