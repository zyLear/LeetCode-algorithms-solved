package com.zylear.problem.leetcode.editor.en;

//Write a program to check whether a given number is an ugly number. 
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
//
// Example 1: 
//
// 
//Input: 6
//Output: true
//Explanation: 6 = 2 × 3 
//
// Example 2: 
//
// 
//Input: 8
//Output: true
//Explanation: 8 = 2 × 2 × 2
// 
//
// Example 3: 
//
// 
//Input: 14
//Output: false 
//Explanation: 14 is not ugly since it includes another prime factor 7.
// 
//
// Note: 
//
// 
// 1 is typically treated as an ugly number. 
// Input is within the 32-bit signed integer range: [−231, 231 − 1]. 
// Related Topics Math 
// 👍 617 👎 707


public class P263UglyNumber {
    public static void main(String[] args) {
        // Solution solution = new P263UglyNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int num) {
            if(num <= 0){
                return false;
            }
            while(num != 1){
                if(num %2 == 0)
                    num = num /2;
                else if(num % 3== 0)
                    num = num /3;
                else if(num % 5 == 0)
                    num = num/5;
                else{
                    return false;
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
