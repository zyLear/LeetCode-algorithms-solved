package com.zylear.problem.leetcode.editor.en;

//Given a non-negative integer x, compute and return the square root of x. 
//
// Since the return type is an integer, the decimal digits are truncated, and on
//ly the integer part of the result is returned. 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since the decimal part is
// truncated, 2 is returned. 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics Math Binary Search 
// 👍 1618 👎 2109


public class P69Sqrtx {
    public static void main(String[] args) {
//        Solution solution = new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {

            if (x == 0) {
                return 0;
            }
            int lower = 0;
            int upper = x;
            while (lower <= upper) {
                int mid = lower + ((upper - lower) / 2);

                // check for overflow
                if (mid > 46340) {
                    upper = mid - 1;
                } else if (x == mid * mid) {
                    return mid;
                } else if (x > mid * mid) {
                    lower = mid + 1;
                } else {
                    upper = mid - 1;
                }
            }
            return upper;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

