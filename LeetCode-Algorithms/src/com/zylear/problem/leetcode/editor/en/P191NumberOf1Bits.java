package com.zylear.problem.leetcode.editor.en;

//Write a function that takes an unsigned integer and returns the number of '1' 
//bits it has (also known as the Hamming weight). 
//
// Note: 
//
// 
// Note that in some languages, such as Java, there is no unsigned integer type.
// In this case, the input will be given as a signed integer type. It should not a
//ffect your implementation, as the integer's internal binary representation is th
//e same, whether it is signed or unsigned. 
// In Java, the compiler represents the signed integers using 2's complement not
//ation. Therefore, in Example 3, the input represents the signed integer. -3. 
// 
//
// 
// Example 1: 
//
// 
//Input: n = 00000000000000000000000000001011
//Output: 3
//Explanation: The input binary string 00000000000000000000000000001011 has a to
//tal of three '1' bits.
// 
//
// Example 2: 
//
// 
//Input: n = 00000000000000000000000010000000
//Output: 1
//Explanation: The input binary string 00000000000000000000000010000000 has a to
//tal of one '1' bit.
// 
//
// Example 3: 
//
// 
//Input: n = 11111111111111111111111111111101
//Output: 31
//Explanation: The input binary string 11111111111111111111111111111101 has a to
//tal of thirty one '1' bits.
// 
//
// 
// Constraints: 
//
// 
// The input must be a binary string of length 32. 
// 
//
// 
//Follow up: If this function is called many times, how would you optimize it? R
//elated Topics Bit Manipulation 
// 👍 1543 👎 649


public class P191NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new P191NumberOf1Bits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {

            int count = 0;
            //java中 n有可能是负数，所以用n==0判断结束循环
            while (n != 0) {
                count += (n & 1);
                n >>>= 1;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}