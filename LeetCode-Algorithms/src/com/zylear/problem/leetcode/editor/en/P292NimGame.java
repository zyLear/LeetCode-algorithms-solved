package com.zylear.problem.leetcode.editor.en;

//You are playing the following Nim Game with your friend: 
//
// 
// Initially, there is a heap of stones on the table. 
// You and your friend will alternate taking turns, and you go first. 
// On each turn, the person whose turn it is will remove 1 to 3 stones from the 
//heap. 
// The one who removes the last stone is the winner. 
// 
//
// Given n, the number of stones in the heap, return true if you can win the gam
//e assuming both you and your friend play optimally, otherwise return false. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: false
//Explanation: These are the possible outcomes:
//1. You remove 1 stone. Your friend removes 3 stones, including the last stone.
// Your friend wins.
//2. You remove 2 stones. Your friend removes 2 stones, including the last stone
//. Your friend wins.
//3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
//In all outcomes, your friend wins.
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: true
// 
//
// Example 3: 
//
// 
//Input: n = 2
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics Brainteaser Minimax 
// 👍 705 👎 1755


import java.util.HashMap;
import java.util.Map;

public class P292NimGame {
    public static void main(String[] args) {
        Solution solution = new P292NimGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        private Map<Integer, Boolean> tempCalculateResult = new HashMap<>();

        public boolean canWinNim(int n) {
            return (n % 4 != 0);
        }


        //动态规划解法
        public boolean canWinNim2(int n) {
            if (n <= 3) {
                return true;
            }

            //dp[n] indicate it's who's turn, left n stones, who win.
            //从前往后推理
            boolean[] dp = new boolean[n];
            dp[1] = true;
            dp[2] = true;
            dp[0] = true;
            for (int i = 3; i < n; i++) {
                dp[i] = !dp[i - 1] || !dp[i - 2] || !dp[i - 3];
            }
            return dp[n-1];

//            return canWinNim(0, n);
        }


        //极小极大算法   时间超时 很多重复工作，可以用一个map记录下来中间结果
        public boolean canWinNim(int turnCount, int n) {

            if (turnCount % 2 == 0) {

//                Boolean bool = tempCalculateResult.get(n);
//                if (bool != null) {
//                    return bool;
//                }

                if (n <= 3) {
                    return true;
                } else {

                    boolean result = canWinNim(turnCount + 1, n - 1) ||
                            canWinNim(turnCount + 1, n - 2) ||
                            canWinNim(turnCount + 1, n - 3);
//                    tempCalculateResult.put(n, result);
                    return result;

                }
            } else {

//                Boolean bool = tempCalculateResult.get(n);
//                if (bool != null) {
//                    return !bool;
//                }

                if (n <= 3) {
                    return false;
                } else {

                    boolean result = canWinNim(turnCount + 1, n - 1) &&
                            canWinNim(turnCount + 1, n - 2) &&
                            canWinNim(turnCount + 1, n - 3);

//                    tempCalculateResult.put(n, !result);
                    return result;
                }

            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}