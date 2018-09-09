package com.zylear.problems.esay.algorithms709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xiezongyu on 2018/9/8.
 */
public class ToLowerCase {

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
            String str = stringToString(line);

            String ret = new Solution().toLowerCase(str);

            String out = (ret);

            System.out.print(out);
        }
    }

    static class Solution {
        public String toLowerCase(String str) {
//        return  str.toLowerCase();
            char[] chars = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int difference = 'a' - 'A';
                if (c >= 'A' & c <= 'Z') {
                    chars[i] = (char) (c + difference);
                } else {
                    chars[i] = c;
                }
            }
            return new String(chars);
        }
    }

}

