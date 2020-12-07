package com.zylear.problem.leetcode.editor.en;

//Given a pattern and a string s, find if s follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a lett
//er in pattern and a non-empty word in s.
//
// 
// Example 1: 
//
// 
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: pattern = "abba", s = "dog dog dog dog"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= pattern.length <= 300 
// pattern contains only lower-case English letters. 
// 1 <= s.length <= 3000 
// s contains only lower-case English letters and spaces ' '. 
// s does not contain any leading or trailing spaces. 
// All the words in s are separated by a single space. 
// 
// Related Topics Hash Table 
// 👍 1588 👎 198


import java.util.HashMap;
import java.util.Map;

public class P290WordPattern {
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {

            if (s == null && pattern == null) {
                return true;
            }
            if ("".equals(s) && "".equals(pattern)) {
                return true;
            }

            String[] strings = s.split(" ");

            if (pattern.length() != strings.length) {
                return false;
            }

            Map<Integer, String> map = new HashMap<>();
            Map<String, Integer> reverseMap = new HashMap<>();


            for (int i = 0; i < pattern.length(); i++) {
                int charInt = pattern.charAt(i);
                String mapString = map.get(charInt);
                if (mapString == null) {

                    Integer integer = reverseMap.get(strings[i]);
                    if (integer == null) {
                        map.put(charInt, strings[i]);
                        reverseMap.put(strings[i], charInt);
                    } else {
                        if (!integer.equals(charInt)) {
                            return false;
                        }
                    }
                } else {
                    if (!mapString.equals(strings[i])) {
                        return false;
                    }
                }
            }

            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}