package com.zylear.problem.leetcode.editor.en;

//Given an array of strings strs, group the anagrams together. You can return 
//the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// 
// Example 2: 
// Input: strs = [""]
//Output: [[""]]
// 
// Example 3: 
// Input: strs = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lowercase English letters. 
// 
//
// Related Topics Array Hash Table String Sorting 👍 15668 👎 447


import java.util.*;

public class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String s = new String(charArray);
                List<String> strings = map.computeIfAbsent(s, k -> new ArrayList<>());
                strings.add(str);
            }

            for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
                result.add(stringListEntry.getValue());
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}