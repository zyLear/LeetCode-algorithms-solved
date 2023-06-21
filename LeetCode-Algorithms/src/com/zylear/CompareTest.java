package com.zylear;

public class CompareTest {

    public static void main(String[] args) {


        long n = 1000000L;

        long count = n * (n - 1) / 2;
        System.out.println(count);

        System.out.println(800000L * 200000L / (double) count);

//        System.out.println("".matches("."));

//        System.out.println(Integer.highestOneBit(-1231233243));

//        System.out.println(highestOneBit1(-1));
//        System.out.println();
//        System.out.println(highestOneBit2(-1));


//        Integer integer = new Integer();
//        integer.
////        System.out.println(i<<31);
//
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);

//        System.out.println(0>>1);
    }

    public static int highestOneBit1(int i) {
        // HD, Figure 3-1
        System.out.println(i >>> 1);
        i |= (i >>> 1);
        System.out.println(i);
        i |= (i >>> 2);
        System.out.println(i);
        i |= (i >>> 4);
        System.out.println(i);
        i |= (i >>> 8);
        System.out.println(i);
        i |= (i >>> 16);
        System.out.println(i);
        return i - (i >>> 1);
    }

    public static int highestOneBit2(int i) {
        // HD, Figure 3-1
        System.out.println(i >> 1);
        i |= (i >> 1);
        System.out.println(i);
        i |= (i >> 2);
        System.out.println(i);
        i |= (i >> 4);
        System.out.println(i);
        i |= (i >> 8);
        System.out.println(i);
        i |= (i >> 16);
        System.out.println(i);
        return i - (i >>> 1);
    }
}
