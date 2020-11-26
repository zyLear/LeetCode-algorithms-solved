package com.zylear.problem.leetcode.editor.en;

//Implement function ToLowerCase() that has a string parameter str, and returns 
//the same string in lowercase. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: "Hello"
//Output: "hello"
// 
//
// 
// Example 2: 
//
// 
//Input: "here"
//Output: "here"
// 
//
// 
// Example 3: 
//
// 
//Input: "LOVELY"
//Output: "lovely"
// 
// 
// 
// Related Topics String 
// 👍 571 👎 1717


public class P709ToLowerCase {
    public static void main(String[] args) {
        Solution solution = new P709ToLowerCase().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toLowerCase(String str) {

            if (str == null) {
                return null;
            }

            char[] chars = new char[str.length()];

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    chars[i] = (char) (str.charAt(i) + 'a' - 'A');
                } else {
                    chars[i] = str.charAt(i);
                }
            }
            return new String(chars);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}