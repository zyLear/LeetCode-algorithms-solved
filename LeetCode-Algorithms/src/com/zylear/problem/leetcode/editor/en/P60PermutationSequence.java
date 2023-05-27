package com.zylear.problem.leetcode.editor.en;

//The set [1, 2, 3, ..., n] contains a total of n! unique permutations. 
//
// By listing and labeling all of the permutations in order, we get the followin
//g sequence for n = 3: 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// Given n and k, return the kth permutation sequence. 
//
// 
// Example 1: 
// Input: n = 3, k = 3
//Output: "213"
// Example 2: 
// Input: n = 4, k = 9
//Output: "2314"
// Example 3: 
// Input: n = 3, k = 1
//Output: "123"
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics Math Backtracking 
// 👍 1958 👎 352


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class P60PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new P60PermutationSequence().new Solution();
        System.out.println(solution.getPermutation(2, 2));

        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean[] visited;

        private int count = 0;
        private final Stack<String> record = new Stack<>();

        public String getPermutation(int n, int k) {
            visited = new boolean[n + 1];
            return backtracking(n, k);
        }

        private String backtracking(int n, int k) {
            if (record.size() == n) {
                count++;
                if (count == k) {
                    return String.join("", record);
                }
                return null;
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    record.push(String.valueOf(i));
                    String backtracking = backtracking(n, k);
                    if (backtracking != null) {
                        return backtracking;
                    }
                    record.pop();
                    visited[i] = false;
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
