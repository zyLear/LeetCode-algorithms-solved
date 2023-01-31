package com.zylear;

public class Test {


    public static void main(String[] args) {
        System.out.println(handle(12));
    }

    static boolean[] dp;

    public static int handle(int n) {
        int length = 1000;
        dp = new boolean[length];

        int temp = 0;
        for (int i = 2; i < length; i++) {

            if (!dp[i]) {
                temp = i + i;
                while (temp < length) {
                    dp[temp] = true;
                    temp = temp + i;
                }
            }
        }


        while (true) {
            if (isHuiwen(n) && isSu(n)) {
                return n;
            }
            n++;
        }
    }

    public static boolean isSu(int n) {

        return !dp[n];

//        for (int i = 2; i <= n/2; i++) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        return true;
    }

    public static boolean isHuiwen(int n) {

        String string = String.valueOf(n);
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) == string.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
