package com.zylear.problems.huawei;

import java.util.Scanner;

/**
 * Created by xiezongyu on 2020/2/7.
 */
public class Exam1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int i = 2;
        while (i-- > 0 && scanner.hasNext()) {
            String string = scanner.nextLine();
            handle(string);
        }


    }

    private static void handle(String string) {

        while (string.length() > 8) {
            System.out.println(string.substring(0, 8));
            string = string.substring(8);
        }
        int count = 8 - string.length();
        if (count != 0) {
            StringBuilder stringBuilder = new StringBuilder(string);
            for (int i = 0; i < count; i++) {
                stringBuilder.append('0');
            }
            string = stringBuilder.toString();
        }
        System.out.println(string);

    }

}
