package com.zylear.problem.leetcode.editor.en;

//Count the number of prime numbers less than a non-negative number, n. 
//
// 
// Example 1: 
//
// 
//Input: n = 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
// 
//
// Example 2: 
//
// 
//Input: n = 0
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: n = 1
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics Hash Table Math 
// 👍 2479 👎 685


import java.util.BitSet;

public class P204CountPrimes {
    public static void main(String[] args) {
        Solution solution = new P204CountPrimes().new Solution();
        System.out.println(solution.countPrimes(10));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            BitSet bitSet = new BitSet(n);

            int count = 0;
            for (int i = 2; i < n; i++) {
                if (!bitSet.get(i)) {
                    count++;
                    int temp = i + i;
                    while (temp < n) {
                        bitSet.set(temp);
                        temp = temp + i;
                    }
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
