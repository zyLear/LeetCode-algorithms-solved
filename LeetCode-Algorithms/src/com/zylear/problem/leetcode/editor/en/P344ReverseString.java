package com.zylear.problem.leetcode.editor.en;

//Write a function that reverses a string. The input string is given as an array
// of characters char[]. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// You may assume all the characters consist of printable ascii characters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// 
//
// 
// Example 2: 
//
// 
//Input: ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// 
// Related Topics Two Pointers String 
// 👍 1947 👎 744


public class P344ReverseString {
    public static void main(String[] args) {
        // Solution solution = new P344ReverseString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int lower = 0;
            int upper = s.length-1;

            while (lower < upper) {
                char tmp = s[lower];
                s[lower] = s[upper];
                s[upper] = tmp;

                lower++;
                upper--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
