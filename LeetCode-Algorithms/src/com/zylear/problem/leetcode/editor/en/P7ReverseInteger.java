package com.zylear.problem.leetcode.editor.en;

//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Note: 
//Assume we are dealing with an environment that could only store integers withi
//n the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this prob
//lem, assume that your function returns 0 when the reversed integer overflows. 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics Math 
// 👍 3998 👎 6174


public class P7ReverseInteger{
    public static void main(String[] args) {
         Solution solution = new P7ReverseInteger().new Solution();

        System.out.println(solution.reverse(-1563847412));
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {


        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        String string = String.valueOf(x);

        int lower= 0;
        int upper = string.length() - 1;
        char[] chars = new char[string.length()];

        while (lower <= upper) {
            if (string.charAt(lower) ==  '-') {
                chars[lower] = string.charAt(lower);
                lower++;
            }
            chars[upper] = string.charAt(lower);
            chars[lower] = string.charAt(upper);
            lower++;
            upper--;
        }
        Long value = Long.parseLong(new String(chars));
        if (value > Integer.MAX_VALUE) {
            return 0;
        } else if (value < Integer.MIN_VALUE) {
            return 0;
        }else {
            return value.intValue();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
