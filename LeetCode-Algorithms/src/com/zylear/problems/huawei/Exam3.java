package com.zylear.problems.huawei;

import java.util.Scanner;

/**
 * Created by xiezongyu on 2020/2/7.
 */
public class Exam3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int i = 1;
        while (i-- > 0 && scanner.hasNext()) {
            String string = scanner.nextLine();
            handle(string);
        }


    }

    private static void handle(String string) {

        char[] chars = string.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newChars[chars.length - 1 - i]=chars[i];
        }
        System.out.println(new String(newChars));
    }


}
