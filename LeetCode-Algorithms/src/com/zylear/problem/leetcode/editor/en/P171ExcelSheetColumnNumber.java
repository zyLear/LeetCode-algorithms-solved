package com.zylear.problem.leetcode.editor.en;

//Given a string columnTitle that represents the column title as appears in an 
//Excel sheet, return its corresponding column number. 
//
// For example: 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
// Example 1: 
//
// 
//Input: columnTitle = "A"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: columnTitle = "AB"
//Output: 28
// 
//
// Example 3: 
//
// 
//Input: columnTitle = "ZY"
//Output: 701
// 
//
// 
// Constraints: 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle consists only of uppercase English letters. 
// columnTitle is in the range ["A", "FXSHRXW"]. 
// 
//
// Related Topics Math String 👍 4267 👎 337


public class P171ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Solution solution = new P171ExcelSheetColumnNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //"B" = 2
        //"BC" = (2)26 + 3
        //"BCM" = (2(26) + 3)26 + 13

        public int titleToNumber(String columnTitle) {
            int result = 0;
            for (char c : columnTitle.toCharArray()) {
                result *= 26;
                result += c - 'A' + 1;
            }
            return result;
        }

        public int titleToNumber1(String columnTitle) {
            int result = 0;
            for (int i = 0; i < columnTitle.length(); i++) {
                result += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - 1 - i);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}