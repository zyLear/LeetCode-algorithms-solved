package com.zylear.problem.leetcode.editor.en;

//Given two integers dividend and divisor, divide two integers without using mul
//tiplication, division, and mod operator. 
//
// Return the quotient after dividing dividend by divisor. 
//
// The integer division should truncate toward zero, which means losing its frac
//tional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2. 
//
// Note: 
//
// 
// Assume we are dealing with an environment that could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume th
//at your function returns 231 − 1 when the division result overflows. 
// 
//
// 
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = truncate(3.33333..) = 3.
// 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = truncate(-2.33333..) = -2.
// 
//
// Example 3: 
//
// 
//Input: dividend = 0, divisor = 1
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: dividend = 1, divisor = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// -231 <= dividend, divisor <= 231 - 1 
// divisor != 0 
// 
// Related Topics Math Binary Search 
// 👍 1424 👎 5898


public class P29DivideTwoIntegers {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        // TO TEST
//    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {

//            if (divisor == 1) {
//                return dividend;
//            }
//            if (divisor == -1) {
//                if (dividend == Integer.MIN_VALUE) {
//                    return Integer.MAX_VALUE;
//                } else {
//                    return -dividend;
//                }
//            }

//
//            boolean change = false;
//            if (dividend < 0 && divisor > 0) {
//                dividend = -dividend;
//                change = true;
//            }
//            if (dividend > 0 && divisor < 0) {
//                divisor = -divisor;
//                change = true;
//            }
//            if (dividend < 0 && divisor < 0) {
//                divisor = -divisor;
//                dividend = -dividend;
//            }
//            int lower = 1;
//            int upper = dividend;
//            while (lower <= upper) {
//
//                int mid = lower + ((upper - lower) / 2);
//                if (mid * divisor == dividend) {
//                    return change ? -mid : mid;
//                } else if (mid * divisor < dividend) {
//                    lower = mid + 1;
//                } else {
//                    upper = mid - 1;
//                }
//            }
//
//            return change ? -upper : upper;

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

