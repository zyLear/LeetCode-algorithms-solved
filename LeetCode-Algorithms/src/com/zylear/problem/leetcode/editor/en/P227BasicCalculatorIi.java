package com.zylear.problem.leetcode.editor.en;

//Given a string s which represents an expression, evaluate this expression and 
//return its value. 
//
// The integer division should truncate toward zero. 
//
// 
// Example 1: 
// Input: s = "3+2*2"
//Output: 7
// Example 2: 
// Input: s = " 3/2 "
//Output: 1
// Example 3: 
// Input: s = " 3+5 / 2 "
//Output: 5
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 105 
// s consists of integers and operators ('+', '-', '*', '/') separated by some n
//umber of spaces. 
// s represents a valid expression. 
// All the integers in the expression are non-negative integers in the range [0,
// 231 - 1]. 
// The answer is guaranteed to fit in a 32-bit integer. 
// 
// Related Topics String Stack 
// 👍 2294 👎 356


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P227BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new P227BasicCalculatorIi().new Solution();
        System.out.println(solution.calculate("2+2*4"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //强行逻辑解题  没什么用
        public int calculate(String s) {
            Set<Character> set = new HashSet<>(Arrays.asList('+', '-'));
            Integer value = null;
            int lastIndex = 0;
            Character lastOperator = null;
            for (int i = 0; i < s.length(); i++) {
                Character character = s.charAt(i);
                if (value == null) {
                    if (set.contains(character)) {
                        String temp = s.substring(lastIndex, i);
                        Integer tempValue = calculatePart2(temp);
                        value = tempValue;
                        lastOperator = character;
                        lastIndex = i + 1;
                    }
                } else {
                    if (set.contains(character)) {
                        String temp = s.substring(lastIndex, i);
                        Integer tempValue = calculatePart2(temp);
                        if (lastOperator == '+') {
                            value = value + tempValue;
                        } else {
                            value = value - tempValue;
                        }
                        lastOperator = character;
                        lastIndex = i + 1;
                    }
                }
            }
            String temp = s.substring(lastIndex);
            Integer tempValue = calculatePart2(temp);
            if (lastOperator == null) {
                value = tempValue;
            } else if (lastOperator == '+') {
                value = value + tempValue;
            } else {
                value = value - tempValue;
            }


            return value;
        }

        private Integer calculatePart2(String s) {
            Set<Character> set = new HashSet<>(Arrays.asList('/', '*'));
            Integer value = null;
            int lastIndex = 0;
            Character lastOperator = null;
            for (int i = 0; i < s.length(); i++) {
                Character character = s.charAt(i);
                if (value == null) {
                    if (set.contains(character)) {
                        String temp = s.substring(lastIndex, i);
                        Integer tempValue = Integer.parseInt(temp.trim());
                        value = tempValue;
                        lastOperator = character;
                        lastIndex = i + 1;
                    }
                } else {
                    if (set.contains(character)) {
                        String temp = s.substring(lastIndex, i);
                        Integer tempValue = Integer.parseInt(temp.trim());
                        if (lastOperator == '*') {
                            value = value * tempValue;
                        } else {
                            value = value / tempValue;
                        }
                        lastOperator = character;
                        lastIndex = i + 1;
                    }
                }
            }
            String temp = s.substring(lastIndex);
            Integer tempValue = Integer.parseInt(temp.trim());
            if (lastOperator == null) {
                value = tempValue;
            } else if (lastOperator == '*') {
                value = value * tempValue;
            } else {
                value = value / tempValue;
            }
            return value;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
