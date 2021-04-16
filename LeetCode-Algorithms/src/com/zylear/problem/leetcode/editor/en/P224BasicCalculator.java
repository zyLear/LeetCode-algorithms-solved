package com.zylear.problem.leetcode.editor.en;

//Given a string s representing an expression, implement a basic calculator to e
//valuate it. 
//
// 
// Example 1: 
//
// 
//Input: s = "1 + 1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: s = " 2-1 + 2 "
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 105 
// s consists of digits, '+', '-', '(', ')', and ' '. 
// s represents a valid expression. 
// 
// Related Topics Math Stack 
// 👍 2151 👎 182


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class P224BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new P224BasicCalculator().new Solution();
        System.out.println(solution.calculate(" 2-1 + 2 "));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        "(1+(4+5+21)-3)+(6+8)"
        public int calculate(String s) {
            Set<Character> set = new HashSet<>(Arrays.asList('(', ')', '+', '-'));
            Stack<Object> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char character = s.charAt(i);
                if (character == ' ') {
                    continue;
                }
                if ('(' == character) {
                    stack.push(character);
                } else if (')' == character) {
                    int tempValue = (int) stack.pop();
                    stack.pop();

                    handleBefore(stack, tempValue);

                } else if ('+' == character || '-' == character) {
                    stack.push(character);
                } else {
                    int tempIndex = i;
                    while (i < s.length() && !set.contains(s.charAt(i))) {
                        i++;
                    }
                    int tempValue = Integer.parseInt(s.substring(tempIndex, i).trim());
                    i--;
                    handleBefore(stack, tempValue);
                }
            }
            return (int) stack.pop();
        }

        private void handleBefore(Stack<Object> stack, int tempValue) {
            if (!stack.isEmpty()) {
                char pop = (char) stack.pop();
                if ('+' == pop) {
                    if (!stack.isEmpty() && stack.peek() instanceof Integer) {
                        int lastValue = (int) stack.pop();
                        stack.push(lastValue + tempValue);
                    } else {
                        stack.push(tempValue);
                    }
                } else if ('-' == pop) {
                    if (!stack.isEmpty() && stack.peek() instanceof Integer) {
                        int lastValue = (int) stack.pop();
                        stack.push(lastValue - tempValue);
                    } else {
                        stack.push(-tempValue);
                    }
                } else {
                    stack.push(pop);
                    stack.push(tempValue);
                }
            } else {
                stack.push(tempValue);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
