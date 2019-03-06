package com.zylear.problems.esay.algorithms20;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by xiezongyu on 2018/9/20.
 */
public class ValidParentheses {

    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }


    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
//            String s = stringToString(line);

            boolean ret = new Solution().isValid(line);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }


    public static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')' && ((stack.isEmpty() || (stack.pop() != '(')))) {
                    return false;
                } else if (c == ']' && ((stack.isEmpty() || (stack.pop() != '[')))) {
                    return false;
                } else if (c == '}' && ((stack.isEmpty() || (stack.pop() != '{')))) {
                    return false;
                }

            }
            return stack.isEmpty();
        }
    }
}
