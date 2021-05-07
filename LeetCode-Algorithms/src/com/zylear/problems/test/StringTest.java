package com.zylear.problems.test;

public class StringTest {

    private static String aa = "aabb";

    private static String i = "aa";
    private static String j = "bb";


    public static void main(String[] args) {
        String a = "aabb";
        final String b = "aa";
        final String c = "bb";
        String d = b + c;  //final  string poll
        String e = "aa" + "bb";  //compiler "aabb"
        String f = "aa";
        String g = "bb";
        String h = f + g;  //heap
        String k = i + j;  //heap  static can change
        System.out.println(aa == a);
        System.out.println(d == a);
        System.out.println(e == a);
        System.out.println(h == a);
        System.out.println(k == a);

    }

}
