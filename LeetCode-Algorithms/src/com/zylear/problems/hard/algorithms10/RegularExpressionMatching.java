package com.zylear.problems.hard.algorithms10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xiezongyu on 2018/9/8.
 */
public class RegularExpressionMatching {


    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String p = stringToString(line);
            long time = System.currentTimeMillis();
            boolean ret = new Solution().isMatch(s, p);
            System.out.println("time: " + (System.currentTimeMillis() - time));
            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

    static class Solution {
        public boolean isMatch(String s, String p) {
            boolean[] map = new boolean[p.length()];
            String new_p = getNewP(p, map);
            boolean[][] match = new boolean[s.length() + 1][new_p.length() + 1];
            match[s.length()][new_p.length()] = true;
            for (int i = new_p.length() - 1; i >= 0; i--) {
                if (!map[i])
                    break;
                else
                    match[s.length()][i] = true;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = new_p.length() - 1; j >= 0; j--) {
                    if (map[j]) {
                        if (s.charAt(i) == new_p.charAt(j) || new_p.charAt(j) == '.') {
                            match[i][j] = match[i][j + 1] || match[i + 1][j];
                        } else {
                            match[i][j] = match[i][j + 1];
                        }
                    } else {
                        if (s.charAt(i) == new_p.charAt(j) || new_p.charAt(j) == '.') {
                            match[i][j] = match[i + 1][j + 1];
                        } else {
                            match[i][j] = false;
                        }
                    }
                }
            }
            return match[0][0];
        }

        private String getNewP(String p, boolean[] map) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    stringBuilder.append(p.charAt(i));
                } else {
                    map[stringBuilder.length() - 1] = true;
                }
            }
            return stringBuilder.toString();
        }
    }


}

