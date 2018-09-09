package com.zylear.problems.medium.algorithms338;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xiezongyu on 2018/9/8.
 */
public class CountingBits {

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            int[] ret = new Solution().countBits(num);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }

    static class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            for (int i = 0; i <= num; i++) {
                result[i] = i % 2 + result[i >>> 1];
            }
            return result;
        }
    }


}

