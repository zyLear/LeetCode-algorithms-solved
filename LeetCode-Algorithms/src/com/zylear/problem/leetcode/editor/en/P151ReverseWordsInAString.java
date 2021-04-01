package com.zylear.problem.leetcode.editor.en;

//Given an input string s, reverse the order of the words. 
//
// A word is defined as a sequence of non-space characters. The words in s will 
//be separated by at least one space. 
//
// Return a string of the words in reverse order concatenated by a single space.
// 
//
// Note that s may contain leading or trailing spaces or multiple spaces between
// two words. The returned string should only have a single space separating the w
//ords. Do not include any extra spaces. 
//
// 
// Example 1: 
//
// 
//Input: s = "the sky is blue"
//Output: "blue is sky the"
// 
//
// Example 2: 
//
// 
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing space
//s.
// 
//
// Example 3: 
//
// 
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single 
//space in the reversed string.
// 
//
// Example 4: 
//
// 
//Input: s = "  Bob    Loves  Alice   "
//Output: "Alice Loves Bob"
// 
//
// Example 5: 
//
// 
//Input: s = "Alice does not even like bob"
//Output: "bob like even not does Alice"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s contains English letters (upper-case and lower-case), digits, and spaces ' 
//'. 
// There is at least one word in s. 
// 
//
// 
// Follow up: Could you solve it in-place with O(1) extra space? 
// Related Topics String 
// 👍 1574 👎 3199


import java.util.Arrays;

public class P151ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new P151ReverseWordsInAString().new Solution();
        System.out.println(solution.reverseWords("   "));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //采用嵌套循环的解法
        //外部一个大循环包含里面自循环的条件
        //里面再一前一后连个子循环处理
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            StringBuilder stringBuilder = new StringBuilder();

            int upper = s.length() - 1;
            int lower = upper;

            while (lower >= 0 && upper >= 0) {

                while (upper >= 0) {
                    if (s.charAt(upper) == ' ') {
                        upper--;
                    } else {
                        break;
                    }
                }
                lower = upper;

                while (lower >= 0) {
                    if (s.charAt(lower) != ' ') {
                        lower--;
                    } else {
                        break;
                    }
                }
                if (lower != upper) {
                    stringBuilder.append(s, lower + 1, upper + 1).append(" ");
                }
                upper = lower;

            }
            return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
