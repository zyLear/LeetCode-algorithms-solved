package com.zylear.problems.other;

/**
 * Created by xiezongyu on 2020/3/4.
 */
public class Hebing {

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 5, 7};
//        int[] b = {10, 12, 14, 34, 57};
//
//        fun1(a, b);

//        fun2(a, 5);

        fun3("112", "1111111111");
    }


    public static void fun1(int a[], int b[]) {
        int i = 0;
        int j = 0;
        int[] array = new int[a.length + b.length];
        int size = 0;

        while (size < a.length + b.length) {
            if (i >= a.length) {
                array[size] = b[j];
                size++;
                j++;
                continue;
            }
            if (j >= b.length) {
                array[size] = a[i];
                size++;
                i++;
                continue;

            }
            if (a[i] < b[j]) {
                array[size] = a[i];
                size++;
                i++;
            } else {
                array[size] = b[j];
                size++;
                j++;
            }
        }

        for (int i1 : array) {
            System.out.print(i1 + "  ");
        }


    }

    public static void fun2(int[] arr, int item) {
//        boolean isItem = false;
        int left = 0;
        int right = arr.length - 1;

        while (true) {
            int mid = left + (right - left) / 2;
            if (item == arr[mid]) {
                System.out.println(mid);
                return;
            } else if (item < arr[mid]) {
                right = mid;
            } else if (item > arr[mid]) {
                left = mid;
            }

            if (mid == left) {
                System.out.println(-1);
                return;
            }

        }
    }


    public static void fun3(String... params) {
        int maxLength = 0;
        //获取最大长度
        for (String s : params) {
            if (s.length() > maxLength) maxLength = s.length();
        }

        StringBuffer result = new StringBuffer();
        //进位 数
        int high = 0;
        //将每个待加参数每一位相加 进位
        for (int i = 0; i < maxLength; i++) {
            int charInt = 0;
            for (String s : params) {
                //高位不够用0代替
                int index = s.length() - 1 - i;
                charInt += index < 0 ? 0 : s.charAt(index) - '0';
            }
            charInt += high;
            //进位
            high = charInt / 10;
            //当前位的值 为charInt 余数
            int remainder = charInt % 10;
            result.append(remainder);
        }
        //最后一次进位
        if (high > 0) {
            result.append(high);
        }
        //反转 输出结果
        System.out.println(result.reverse());
    }

    public static void fun4(String string) {
        char[] chars = string.toCharArray();
        int lastIndex = chars.length;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] == ' ') {

            }
        }
    }


}
