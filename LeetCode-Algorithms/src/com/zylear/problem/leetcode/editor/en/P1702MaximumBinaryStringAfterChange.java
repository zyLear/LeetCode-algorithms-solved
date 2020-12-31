package com.zylear.problem.leetcode.editor.en;

//You are given a binary string binary consisting of only 0's or 1's. You can ap
//ply each of the following operations any number of times: 
//
// 
// Operation 1: If the number contains the substring "00", you can replace it wi
//th "10".
//
// 
// For example, "00010" -> "10010" 
// 
// 
// Operation 2: If the number contains the substring "10", you can replace it wi
//th "01".
// 
// For example, "00010" -> "00001" 
// 
// 
// 
//
// Return the maximum binary string you can obtain after any number of operation
//s. Binary string x is greater than binary string y if x's decimal representation
// is greater than y's decimal representation. 
//
// 
// Example 1: 
//
// 
//Input: binary = "000110"
//Output: "111011"
//Explanation: A valid transformation sequence can be:
//"000110" -> "000101" 
//"000101" -> "100101" 
//"100101" -> "110101" 
//"110101" -> "110011" 
//"110011" -> "111011"
// 
//
// Example 2: 
//
// 
//Input: binary = "01"
//Output: "01"
//Explanation: "01" cannot be transformed any further.
// 
//
// 
// Constraints: 
//
// 
// 1 <= binary.length <= 105 
// binary consist of '0' and '1'. 
// 
// Related Topics Greedy 
// 👍 114 👎 12


public class P1702MaximumBinaryStringAfterChange {
    public static void main(String[] args) {
        // Solution solution = new P1702MaximumBinaryStringAfterChange().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //找规律法  最后只剩一个0   假设有n个0，最后一个0的位置在从第一个0开始的往后推n个位置
        public String maximumBinaryString(String binary) {
            //00  -  10
            //10  -  01

            StringBuilder stringBuilder = new StringBuilder();
            int count = 0;
            int start = 0;
            boolean bool = false;
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '0') {
                    count++;
                    if (!bool) {
                        bool = true;
                        start = i;
                    }
                }
            }
            if (!bool) {
                return binary;
            }

            for (int i = 0; i < binary.length(); i++) {

                if (i == count - 1 + start) {
                    stringBuilder.append('0');
                } else {
                    stringBuilder.append('1');
                }

            }

            return stringBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
