package com.zylear.problem.leetcode.editor.en;

//Given n, how many structurally unique BST's (binary search trees) that store v
//alues 1 ... n?
//
// Example: 
//
// 
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
// Related Topics Dynamic Programming Tree 
// 👍 4032 👎 147


public class P96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int count = 0;

        public int numTrees(int n) {

//            for (int i = 1; i <= n; i++) {
//
//            }

            return numTrees(1, n);
        }

        //暴力求解  时间超时
        public int numTrees(int start, int end) {
            if (end < start) {
                return 1;
            }

            int count = 0;
            for (int i = start; i <= end; i++) {
                int leftCount = numTrees(start, i - 1);
                int rightCount = numTrees(i + 1, end);
                count = count + (leftCount * rightCount);
            }

            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}