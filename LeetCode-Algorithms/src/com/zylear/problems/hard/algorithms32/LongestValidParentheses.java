package com.zylear.problems.hard.algorithms32;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by xiezongyu on 2018/9/10.
 */
public class LongestValidParentheses {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution().longestValidParentheses(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    static class Solution {

        public int longestValidParentheses(String s) {
            int leftCount = 0;
            int count = 0;
            int maxCount = 0;


//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == '(') {
//                    leftCount++;
//                } else {
//                    if (leftCount > 0) {
//                        leftCount--;
//                        count++;
//                    }else {
//                        if (count > maxCount) {
//                            maxCount = count;
//                        }
//                        count = 0;
//                    }
//                }
//            }
//            return count * 2;


//            int maxans = 0;
//            Stack<Integer> stack = new Stack<>();
//            stack.push(-1);
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == '(') {
//                    stack.push(i);
//                } else {
//                    stack.pop();
//                    if (stack.empty()) {
//                        stack.push(i);
//                    } else {
//                        maxans = Math.max(maxans, i - stack.peek());
//                    }
//                }
//            }
//            return maxans;


            int maxans = 0;
            int dp[] = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;



//            if ("".equals(s)) {
//                return 0;
//            }
//            int[][] dp = new int[s.length()][s.length()];
//            for (int i = s.length() - 2; i >= 0; i--) {
//                for (int j = s.length() - 1; j >= i; j--) {
//                    if (s.charAt(i) == ')') {
//                        dp[i][j] = dp[i + 1][j];
//                    } else {
//                        if (s.charAt(i + 1) == ')') {
//                            dp[i][j] = dp[i + 1][j] + 1;
//                        } else {
//                            dp[i][j] = dp[i + 1][j];
//                        }
//                    }
//                }
//            }
//            return dp[0][s.length() - 1] * 2;
        }
    }
//()(()

}
