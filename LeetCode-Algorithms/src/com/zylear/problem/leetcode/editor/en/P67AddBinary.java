package com.zylear.problem.leetcode.editor.en;

//Given two binary strings a and b, return their sum as a binary string. 
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 104 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
// Related Topics Math String 
// 👍 2279 👎 303


public class P67AddBinary {
    public static void main(String[] args) {
//        Solution solution = new P67AddBinary().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder stringBuilder = new StringBuilder();
            int add = 0;
            int i = a.length() - 1;
            int j = b.length() - 1;
            while (i >= 0 || j >= 0 || add > 0) {

                int valueA = 0;
                if (i >= 0) {
                    valueA = a.charAt(i) - '0';
                }
                int valueB = 0;
                if (j >= 0) {
                    valueB = b.charAt(j) - '0';
                }
                int count = valueA + valueB + add;


                if (count >= 2) {
                    add = count / 2;
                    stringBuilder.append(count % 2);
                }else {
                    add = 0;
                    stringBuilder.append(count);

                }

                i--;
                j--;

            }
            return stringBuilder.reverse().toString();


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

