package com.zylear.problem.leetcode.editor.en;

//Given a non-empty array of decimal digits representing a non-negative integer,
// increment one to the integer. 
//
// The digits are stored such that the most significant digit is at the head of
//the list, and each element in the array contains a single digit.
//
// You may assume the integer does not contain any leading zero, except the numb
//er 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
// 
//
// Example 2: 
//
// 
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
// 
//
// Example 3: 
//
// 
//Input: digits = [0]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics Array 
// 👍 1902 👎 2743


public class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            boolean jump = false;
            for (int i = digits.length - 1; i >= 0; i--) {
                int temp = digits[i] + 1;
                if (temp < 10) {
                    digits[i] = temp;
                    jump = true;
                    break;
                } else {
                    digits[i] = temp % 10;
                }
            }

            if (!jump) {
                int[] array = new int[digits.length + 1];
                array[0] = 1;
                System.arraycopy(digits, 0, array, 1, digits.length);
                return array;
            }
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

