package com.zylear.problem.leetcode.editor.en;

//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics Backtracking 
// 👍 1898 👎 78


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P77Combinations {
    public static void main(String[] args) {
        // Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> result = new LinkedList<>();
        Stack<Integer> record = new Stack<>();

        public List<List<Integer>> combine(int n, int k) {

            backtrack(1, n, k);
            return result;
        }

        private void backtrack(int indexOfAttempts, int n, int k) {
            if (record.size() == k) {
                result.add(new ArrayList<>(record));
                return;
            }

            for (int i = indexOfAttempts; i <= n; i++) {
                if (n - i + 1 + record.size() < k) {
                    break;
                }

                record.push(i);
                backtrack(i + 1, n, k);
                record.pop();

            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
