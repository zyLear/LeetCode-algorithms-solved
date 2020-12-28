package com.zylear.problem.leetcode.editor.en;

//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Backtracking 
// 👍 6704 👎 304


import java.util.LinkedList;
import java.util.List;

public class P22GenerateParentheses {
    public static void main(String[] args) {
        // Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new LinkedList<>();
        StringBuilder record = new StringBuilder();

        public List<String> generateParenthesis(int n) {

            backtrack(0, 0, n);

            return result;
        }

        private void backtrack(int leftCount, int rightCount, int n) {

            if (leftCount == n && rightCount == n) {
                result.add(record.toString());
            }
            //尝试集只有两种
            if (leftCount < n) {
                record.append("(");
                backtrack(leftCount + 1, rightCount, n);
                record.deleteCharAt(record.length() - 1);
            }

            if (rightCount < leftCount) {
                record.append(")");
                backtrack(leftCount, rightCount + 1, n);
                record.deleteCharAt(record.length() - 1);
            }

        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
