package com.zylear.problem.leetcode.editor.en;

//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 
// 👍 12001 👎 644


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("asjrgapa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            //这个start很关键，存的是最后一个不重复（相等）的下标
            int start = 0;
            int end = 0;
            int max = 0;
            while (start < s.length() && end < s.length()) {

                if (map.containsKey(s.charAt(end))) {
                    start = Math.max(map.get(s.charAt(end)), start);
                }
                //设置或更新当前字符的最后一个不重复（相等）的下标，所以要+1
                map.put(s.charAt(end), end + 1);
                max = Math.max(max, end - start + 1);
                end++;
            }
            return max;
        }

        public int lengthOfLongestSubstring2(String s) {
            Set<Character> set = new HashSet<>();
            //上次不相等的地方
            int start = 0;
            int end = 0;
            int max = 0;
            while (start < s.length() && end < s.length()) {

                if (!set.contains(s.charAt(end))) {
                    set.add(s.charAt(end));
                    max = Math.max(max, end - start + 1);
                    end++;
                } else {
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            return max;
        }


        public int lengthOfLongestSubstring1(String s) {
            Set<Integer> set = new HashSet<>();

            int max = 0;
            for (int j = 0; j < s.length(); j++) {
                int count = 0;
                set.clear();
                for (int i = j; i < s.length(); i++) {

                    int integer = s.charAt(i);
                    if (set.contains(integer)) {

                        if (count > max) {
                            max = count;
                        }
                        set.clear();
                        set.add(integer);
                        count = 1;

                    } else {
                        set.add(integer);
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                }
            }


            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}