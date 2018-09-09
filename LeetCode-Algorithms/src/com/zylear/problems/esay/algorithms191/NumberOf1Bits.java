package com.zylear.problems.esay.algorithms191;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xiezongyu on 2018/9/9.
 */
public class NumberOf1Bits {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            int out = new Solution().hammingWeight(num);


            System.out.print(out);
        }
    }

    static class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = n; i != 0; i = i >>> 1) {
                count += i & 1;
            }
            return count;
        }
    }

    static class SolutionV2 {
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = n; i != 0; i = i >>> 1) {
                count += Math.abs(i % 2);
            }
            return count;
        }
    }

    static class SolutionV3 {
        public int hammingWeight(int n) {
            int bits = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    bits++;
                }
                mask <<= 1;
            }
            return bits;
        }
    }


}
