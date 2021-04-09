package com.zylear.problem.leetcode.editor.en;

//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// A palindrome string is a string that reads the same backward as forward. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
// Related Topics Dynamic Programming Backtracking Depth-first Search 
// 👍 3238 👎 102


import java.util.*;

public class P131PalindromePartitioning {
    public static void main(String[] args) {
        // Solution solution = new P131PalindromePartitioning().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> partition(String s) {
            Map<Integer, List<List<String>>> map = new HashMap<>();

            for (int i = 1; i <= s.length(); i++) {
                List<List<String>> result = new LinkedList<>();
                for (int j = 1; j <= s.length(); j++) {
                    if (j == 1) {
                        String substring = s.substring(j - 1, i);
                        if (judge(substring)) {
                            result.add(Collections.singletonList(substring));
                        }
                    } else {
                        List<List<String>> lists = map.get(j - 1);
                        if (lists != null) {
                            String substring = s.substring(j - 1, i);
                            if (judge(substring)) {
                                for (List<String> list : lists) {
                                    ArrayList<String> strings = new ArrayList<>(list);
                                    strings.add(substring);
                                    result.add(strings);
                                }
                            }
                        }
                    }
                }
                map.put(i, result);
            }


            return map.get(s.length());
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
