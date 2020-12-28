package com.zylear.problem.leetcode.editor.en;

//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// Related Topics String Backtracking Depth-first Search Recursion 
// 👍 4991 👎 470


import java.util.*;

public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> result = new LinkedList<>();
        StringBuilder record = new StringBuilder();
        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            if (digits == null || "".equals(digits)) {
                return result;
            }
            backtrack(0, digits);

            return result;
        }

        private void backtrack(int startIndexOfAttempts, String digits) {
            if (startIndexOfAttempts == digits.length()) {
                result.add(record.toString());
                return;
            }
            char c = digits.charAt(startIndexOfAttempts);
            String strings = phone.get(String.valueOf(c));
            for (int i = 0; i < strings.length(); i++) {
                record.append(strings.charAt(i));
                backtrack(startIndexOfAttempts + 1, digits);
                record.deleteCharAt(record.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
