package com.zylear.problem.leetcode.editor.en;

//Write an algorithm to determine if a number n is "happy". 
//
// A happy number is a number defined by the following process: Starting with an
//y positive integer, replace the number by the sum of the squares of its digits, 
//and repeat the process until the number equals 1 (where it will stay), or it loo
//ps endlessly in a cycle which does not include 1. Those numbers for which this p
//rocess ends in 1 are happy numbers. 
//
// Return True if n is a happy number, and False if not. 
//
// Example: 
//
// 
//Input: 19
//Output: true
//Explanation: 
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics Hash Table Math 
// 👍 2619 👎 465


import java.util.HashMap;
import java.util.Map;

public class P202HappyNumber {
    public static void main(String[] args) {
        // Solution solution = new P202HappyNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            //用map存储中间结果 判断去重
            Map<Integer, Integer> map = new HashMap<>();
//            int count = n;
            while (n != 1 /*&& map.get(n) != null*/) {
                if (map.get(n) != null) {
                    return false;
                }

                int temp = 0;
                int tempN = n;
                while (tempN > 0) {
                    temp += (tempN % 10) * (tempN % 10);
                    tempN = tempN / 10;
                }

                map.put(n, temp);
                n = temp;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
