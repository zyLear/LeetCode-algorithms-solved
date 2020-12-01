package com.zylear.problem.leetcode.editor.en;

//Given an integer n, return true if it is a power of two. Otherwise, return fal
//se. 
//
// An integer n is a power of two, if there exists an integer x such that n == 2
//x. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 2^0 = 1
// 
//
// Example 2: 
//
// 
//Input: n = 16
//Output: true
//Explanation: 2^4 = 16
// 
//
// Example 3: 
//
// 
//Input: n = 3
//Output: false
// 
//
// Example 4: 
//
// 
//Input: n = 4
//Output: true
// 
//
// Example 5: 
//
// 
//Input: n = 5
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -231 <= n <= 231 - 1 
// 
// Related Topics Math Bit Manipulation 
// 👍 1117 👎 205


public class P231PowerOfTwo {
    public static void main(String[] args) {
        // Solution solution = new P231PowerOfTwo().new Solution();
        // TO TESTq
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            int count = 1;
            int i = 32;
            while (i-- > 0) {
                if (count == n) {
                    return true;
                } else {
                    count <<= 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
