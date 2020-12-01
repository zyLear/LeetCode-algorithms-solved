package com.zylear.problem.leetcode.editor.en;

//Given a positive integer, return its corresponding column title as appear in a
//n Excel sheet. 
//
// For example: 
//
// 
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// Example 1: 
//
// 
//Input: 1
//Output: "A"
// 
//
// Example 2: 
//
// 
//Input: 28
//Output: "AB"
// 
//
// Example 3: 
//
// 
//Input: 701
//Output: "ZY"
// Related Topics Math 
// 👍 1441 👎 275


public class P168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new P168ExcelSheetColumnTitle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int n) {
            StringBuilder stringBuilder = new StringBuilder();

            while (n > 0) {
                n--;
                int count = n % 26;
                stringBuilder.append((char) ('A' + count));
                n /= 26;
            }

            return stringBuilder.reverse().toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}