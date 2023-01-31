package com.zylear.problems.huawei;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiezongyu on 2020/2/7.
 */
public class ExamTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        File file = new File("sdf");
        try {
            FileWriter inputStream = new FileWriter(file, false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int i = 1;
        while (i-- > 0 && scanner.hasNext()) {
            String string = scanner.nextLine();
            handle(string);
        }

        Thread thread;
    }

    private static void handle(String string) {

        ConcurrentHashMap concurrentHashMap;
//        concurrentHashMap.put()

        char[] chars = string.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newChars[chars.length - 1 - i] = chars[i];
        }
        System.out.println(new String(newChars));
    }


}

