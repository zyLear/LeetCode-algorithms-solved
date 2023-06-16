package com.zylear.problem.leetcode.editor.en;

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
//of rows like this: (you may want to display this pattern in a fixed font for 
//better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a 
//number of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
//
// Related Topics String 👍 6263 👎 12457


import java.util.ArrayList;
import java.util.List;

public class P6ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new P6ZigzagConversion().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            List<StringBuilder> list = new ArrayList<>(numRows);
            for (int i = 0; i < numRows; i++) {
                list.add(new StringBuilder());
            }

            int index = 0;

            while (index < s.length()) {

                //垂直向下
                int n = 0;
                while (index < s.length() && n < numRows) {
                    list.get(n).append(s.charAt(index));
                    n++;
                    index++;
                }

                //斜方向遍历
                int i = numRows - 2;
                while (index < s.length() && i > 0) {
                    list.get(i).append(s.charAt(index));
                    i--;
                    index++;
                }
            }

            StringBuilder result = new StringBuilder();
            for (StringBuilder stringBuilder : list) {
                result.append(stringBuilder);
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}