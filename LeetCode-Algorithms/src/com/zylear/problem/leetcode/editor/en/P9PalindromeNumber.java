package com.zylear.problem.leetcode.editor.en;

//Determine whether an integer is a palindrome. An integer is a palindrome when 
//it reads the same backward as forward. 
//
// Follow up: Could you solve it without converting the integer to a string? 
//
// 
// Example 1: 
//
// 
//Input: x = 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Example 4: 
//
// 
//Input: x = -101
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics Math 
// 👍 2784 👎 1648


public class P9PalindromeNumber{
    public static void main(String[] args) {
        // Solution solution = new P9PalindromeNumber().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isPalindrome(int x) {
            String string = String.valueOf(x);

            int lower = 0 ;
            int upper = string.length() - 1;

            while (lower <= upper) {
                if (string.charAt(lower) != string.charAt(upper)) {
                    return false;
                }
                lower++;
                upper--;
            }
            return true;
        }


        public boolean isPalindrome2(int x) {
            if(x<0 || ( x%10==0 && x!=0)){
                return false;
            }

            //存后一部分
            int revertedNumber = 0;

            while(x > revertedNumber){

                revertedNumber = revertedNumber * 10 + x % 10;
                x/=10;

            }

            return x==revertedNumber || x == revertedNumber/10;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
