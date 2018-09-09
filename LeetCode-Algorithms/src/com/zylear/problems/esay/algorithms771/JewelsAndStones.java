package com.zylear.problems.esay.algorithms771;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * Created by xiezongyu on 2018/9/8.
 */


/*
    You're given strings J representing the types of stones that are jewels,
    and S representing the stones you have.  Each character in S is a type of stone you have.
    You want to know how many of the stones you have are also jewels.

    The letters in J are guaranteed distinct, and all characters in J and S are letters.
    Letters are case sensitive, so "a" is considered a different type of stone from "A".

    Example 1:

    Input: J = "aA", S = "aAAbbbb"
    Output: 3
    Example 2:

    Input: J = "z", S = "ZZ"
    Output: 0
    Note:

    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.
*/

public class JewelsAndStones {

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
            String J = stringToString(line);
            line = in.readLine();
            String S = stringToString(line);

            int ret = new Solution().numJewelsInStones(J, S);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    static class Solution {

        int numJewelsInStones(String J, String S) {
            int count = 0;
            for (int i = 0; i < S.length(); i++) {
                for (int j = 0; j < J.length(); j++) {
                    if (J.charAt(j) == S.charAt(i)) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

}



