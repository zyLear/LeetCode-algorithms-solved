package com.zylear.problem.leetcode.editor.en;

//Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases. 
//
// Note: For the purpose of this problem, we define empty string as valid palind
//rome. 
//
// Example 1: 
//
// 
//Input: "A man, a plan, a canal: Panama"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "race a car"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// s consists only of printable ASCII characters. 
// 
// Related Topics Two Pointers String 
// 👍 1573 👎 3322


public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST

        System.out.println(solution.isPalindrome("0P"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }
            int lower = 0;
            int upper = s.length() - 1;

            while (lower <= upper) {

                if (((s.charAt(lower) < 'a' || s.charAt(lower) > 'z') &&
                        (s.charAt(lower) < 'A' || s.charAt(lower) > 'Z')) &&
                        (s.charAt(lower) < '0' || s.charAt(lower) > '9')) {
                    lower++;
                    continue;
                }

                if (((s.charAt(upper) < 'a' || s.charAt(upper) > 'z') &&
                        (s.charAt(upper) < 'A' || s.charAt(upper) > 'Z')) &&
                        (s.charAt(upper) < '0' || s.charAt(upper) > '9')) {
                    upper--;
                    continue;
                }

                if (lower > upper) {
                    break;
                }

                int lowerChar = s.charAt(lower) < 'a' ? s.charAt(lower) + 'a' - 'A' : s.charAt(lower);
                int upperChar = s.charAt(upper) < 'a' ? s.charAt(upper) + 'a' - 'A' : s.charAt(upper);

                if (lowerChar != upperChar) {
                    return false;
                }
                lower++;
                upper--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
