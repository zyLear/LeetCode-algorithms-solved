package com.zylear.problem.leetcode.editor.en;

//Given two non-negative integers num1 and num2 represented as strings, return 
//the product of num1 and num2, also represented as a string. 
//
// Note: You must not use any built-in BigInteger library or convert the inputs 
//to integer directly. 
//
// 
// Example 1: 
// Input: num1 = "2", num2 = "3"
//Output: "6"
// 
// Example 2: 
// Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 and num2 consist of digits only. 
// Both num1 and num2 do not contain any leading zero, except the number 0 
//itself. 
// 
//
// Related Topics Math String Simulation 👍 6266 👎 2848


public class P43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new P43MultiplyStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {

            int[] result = new int[num1.length() + num2.length()];

            for (int i = num1.length() - 1; i >= 0; i--) {
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    //找到在结果数组里面的index
                    //总长度 - (占0的长度 两个数组占0长度) -1
//                    int p1 = result.length - (num1.length() - 1 - i) - (num2.length() - 1 - j) - 1;
                    int p1 = i + j + 1;
                    int p2 = i + j;
                    int sum = result[p1] + temp;
                    result[p1] = sum % 10;
                    result[p2] = sum / 10 + result[p2];
                    //一轮遍历下来，得到精确结果 p1，p2只是一个缓存值，可能大于10，
                    //下一次遍历就会处理到精确结果了，个位数
                }
            }


            StringBuilder sb = new StringBuilder();
            for (int p : result) {
                if (sb.length() == 0 && p == 0) {
                    continue;
                }
                sb.append(p);
            }
            return sb.length() == 0 ? "0" : sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}