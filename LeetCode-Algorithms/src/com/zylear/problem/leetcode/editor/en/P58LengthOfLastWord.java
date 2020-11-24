package com.zylear.problem.leetcode.editor.en;

//Given a string s consists of some words separated by spaces, return the length
// of the last word in the string. If the last word does not exist, return 0. 
//
// A word is a maximal substring consisting of non-space characters only. 
//
// 
// Example 1: 
// Input: s = "Hello World"
//Output: 5
// Example 2: 
// Input: s = " "
//Output: 0
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of only English letters and spaces ' '. 
// 
// Related Topics String 
// 👍 848 👎 2843


public class P58LengthOfLastWord {
    public static void main(String[] args) {
//        Solution solution = new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int index = -1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                return 0;
            }

            for (int i = index - 1; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    return index - i;
                }
            }
            return index + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

