package com.zylear.problem.leetcode.editor.en;

//Implement pow(x, n), which calculates x raised to the power n (i.e. xn). 
//
// 
// Example 1: 
//
// 
//Input: x = 2.00000, n = 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: x = 2.10000, n = 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
// Constraints: 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics Math Binary Search 
// 👍 1950 👎 3470


public class P50PowxN {
    public static void main(String[] args) {
        // Solution solution = new P50PowxN().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
//            Long n = (long) n;
            if (n < 0) {
                x = 1 / x;
                n = -n;
            }
//            double s = x;
//            double response = 1;
//            if ((n & 1) == 1) {
//                n = n + 1;
//            }
//            while (n > 0) {

//                if (n == 1) {
//                    return x * s;
//                }
//                if ((n & 1) == 1) {
//                    response = response * x;
//                }
//                x = x * x;
//                n = n >> 1;

//            }
            //(x)^n  = (x*x)^2

//            return x/s;

            return pox(x, n);

        }

        private double pox(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (x % 2 == 1) {
                return pox(x, n - 1) * x;
            } else {
                double pox = pox(x, n / 2);
                return pox * pox;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
