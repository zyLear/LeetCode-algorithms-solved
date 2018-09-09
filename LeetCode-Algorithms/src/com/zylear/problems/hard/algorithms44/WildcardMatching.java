package com.zylear.problems.hard.algorithms44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xiezongyu on 2018/9/8.
 */
public class WildcardMatching {


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
            boolean ret = new SolutionV2().isMatch(s, p);
            System.out.println("time: " + (System.currentTimeMillis() - time));
            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

    static class SolutionV2 {
        public boolean isMatch(String s, String p) {
            boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
            match[s.length()][p.length()] = true;
            for (int i = p.length() - 1; i >= 0; i--) {
                if (p.charAt(i) != '*')
                    break;
                else
                    match[s.length()][i] = true;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = p.length() - 1; j >= 0; j--) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                        match[i][j] = match[i + 1][j + 1];
                    else if (p.charAt(j) == '*')
                        match[i][j] = match[i + 1][j] || match[i][j + 1];
                    else
                        match[i][j] = false;
                }
            }
            return match[0][0];
        }
    }


    static class Solution {
        int[][] record;
        int s_length;
        int p_length;

        public boolean isMatch(String s, String p) {
            record = new int[s.length() + 1][p.length() + 1];
            s_length = s.length();
            p_length = p.length();
            isMatchLoop(s, p, record, s_length, p_length);
            return record[0][0] == 2;
        }

        public boolean isMatchLoop(String s, String p, int[][] record, int s_length, int p_length) {
            if (this.record[this.s_length - s.length()][this.p_length - p.length()] == 2) {
                return true;
            } else if (this.record[this.s_length - s.length()][this.p_length - p.length()] == 1) {
                return false;
            }
            if (judgeLength(s, p)) {
                this.record[this.s_length - s.length()][this.p_length - p.length()] = 1;
                return false;
            }
            int s_index = 0;
            for (int i = 0; i < p.length(); i++) {
                char c_char = p.charAt(i);
                if (c_char == '*') {
                    if (i == p.length() - 1) {
                        this.record[this.s_length - s.length()][this.p_length - p.length()] = 2;
                        return true;
                    } else if (p.charAt(i + 1) == '*') {
                        continue;
                    }
                    char next_char = p.charAt(i + 1);
                    int[] points = new int[255];
                    int count;
                    if (next_char == '?') {
                        for (int j = s_index; j < s.length(); j++) {
                            if (isMatchLoop(s.substring(j), p.substring(i + 1), record, s_length, p_length)) {
                                this.record[this.s_length - s.length()][this.p_length - p.length()] = 2;
                                return true;
                            } else {
                                this.record[this.s_length - s.length()][this.p_length - p.length()] = 1;
                            }
                        }
                    } else {
                        count = findNextPoints(s_index, s, points, p, i);
                        for (int j = 0; j < count; j++) {
                            if (isMatchLoop(s.substring(points[j]), p.substring(i + 1), record, s_length, p_length)) {
                                this.record[this.s_length - s.length()][this.p_length - p.length()] = 2;
                                return true;
                            } else {
                                this.record[this.s_length - s.length()][this.p_length - p.length()] = 1;
                            }
                        }
                    }
                    this.record[this.s_length - s.length()][this.p_length - p.length()] = 1;
                    return false;
                } else if (c_char == '?') {
                    if (s_index >= s.length()) {
                        this.record[this.s_length - s.length()][this.p_length - p.length()] = 1;
                        return false;
                    }
                    s_index++;
                } else {
                    if (s_index >= s.length()) {
                        this.record[this.s_length - s.length()][this.p_length - p.length()] = 1;
                        return false;
                    }
                    char s_char = s.charAt(s_index);
                    if (s_char == c_char) {
                        s_index++;
                    } else {
                        this.record[this.s_length - s.length()][this.p_length - p.length()] = 1;
                        return false;
                    }
                }
            }
            boolean b = s_index == s.length();
            if (b) {
                this.record[this.s_length - s.length()][this.p_length - p.length()] = 2;
            } else {
                this.record[this.s_length - s.length()][this.p_length - p.length()] = 1;
            }
            return b;
        }

        private boolean judgeLength(String s, String p) {
            int count = 0;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    count++;
                }
            }
            return count > s.length();
        }

        private int findNextPoints(int s_index, String s, int[] points, String p, int p_index) {
            StringBuilder stringBuilder = new StringBuilder("");
            for (int j = p_index + 1; j < p.length(); j++) {
                char c = p.charAt(j);
                if (c != '*' && c != '?') {
                    stringBuilder.append(p.charAt(j));
                } else {
                    break;
                }
            }
            int count = 0;
            for (int i = s_index; i < s.length(); i++) {
                for (int t = 0; t < stringBuilder.length(); t++) {
                    if (i + t >= s.length()) {
                        break;
                    }
                    if (s.charAt(i + t) != stringBuilder.charAt(t)) {
                        break;
                    }
                    if (t == stringBuilder.length() - 1) {
                        points[count] = i;
                        count++;
                    }
                }
            }
            return count;
        }
    }

}

