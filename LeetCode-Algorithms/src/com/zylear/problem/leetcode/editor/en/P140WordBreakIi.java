package com.zylear.problem.leetcode.editor.en;

//Given a string s and a dictionary of strings wordDict, add spaces in s to cons
//truct a sentence where each word is a valid dictionary word. Return all such pos
//sible sentences in any order. 
//
// Note that the same word in the dictionary may be reused multiple times in the
// segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//Output: ["cats and dog","cat sand dog"]
// 
//
// Example 2: 
//
// 
//Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","p
//ineapple"]
//Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//Explanation: Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
// Related Topics Dynamic Programming Backtracking 
// 👍 3053 👎 443


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P140WordBreakIi {
    public static void main(String[] args) {
        // Solution solution = new P140WordBreakIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Map<Integer, List<String>> map = new HashMap<>(s.length());

            for (int i = 0; i < s.length(); i++) {
                LinkedList<String> list = new LinkedList<>();
                String result = judge(s, wordDict, 0, i + 1);
                if (result != null) {
                    list.add(result);
                }

                for (int j = 0; j < i; j++) {
                    List<String> strings = map.get(j);
                    if (!strings.isEmpty()) {
                        result = judge(s, wordDict, j + 1, i + 1);
                        if (result != null) {
                            for (String string : strings) {
                                list.add(string + " " + result);
                            }
                        }
                    }
                }

                map.put(i, list);
            }



            return map.get(s.length() - 1);
        }

        private String judge(String s, List<String> wordDict, int start, int end) {
            String substring = s.substring(start, end);
            for (String string : wordDict) {
                if (substring.equals(string)) {
                    return string;
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
