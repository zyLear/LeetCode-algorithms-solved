package com.zylear.problem.leetcode.editor.en;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
//
// Valid operators are +, -, *, /. Each operand may be an integer or another exp
//ression. 
//
// Note: 
//
// 
// Division between two integers should truncate toward zero. 
// The given RPN expression is always valid. That means the expression would alw
//ays evaluate to a result and there won't be any divide by zero operation. 
// 
//
// Example 1: 
//
// 
//Input: ["2", "1", "+", "3", "*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
// 
//
// Example 2: 
//
// 
//Input: ["4", "13", "5", "/", "+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
// 
//
// Example 3: 
//
// 
//Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//Output: 22
//Explanation: 
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// 
// Related Topics Stack 
// 👍 1312 👎 497


import java.util.Stack;

public class P150EvaluateReversePolishNotation {
    public static void main(String[] args) {
        // Solution solution = new P150EvaluateReversePolishNotation().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {

            Stack<Integer> stack = new Stack<>();

            for (String token : tokens) {
                if ("+".equals(token) || "-".equals(token) ||
                        "*".equals(token) || "/".equals(token)) {
                    Integer two = stack.pop();
                    Integer one = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(one + two);
                            break;
                        case "-":
                            stack.push(one - two);
                            break;
                        case "*":
                            stack.push(one * two);
                            break;
                        case "/":
                            stack.push(one / two);
                            break;

                        default:
                    }
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
