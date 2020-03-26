package com.zylear.problems.test;

import java.util.*;

/**
 * Created by xiezongyu on 2020/2/9.
 */
public class Main {

    public static void main(String[] args) {
        String string = "abc";
        char[] chars = string.toCharArray();
        System.out.println(new StringBuilder(string).reverse().toString());
        for (int i = 0; i < chars.length - 1 - i; i++) {
            char temp = chars[i];
            chars[i]=   chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        for (char aChar : chars) {
            System.out.println(aChar);
        }

    }
    public String[] fun(Set<String> whiteList, Set<String> totalSet) {

        String[] output = new String[20000];
        int count = 19999;
        Iterator<String> iterator = totalSet.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (whiteList.contains(string)) {
                output[count] = string;
                count--;
                iterator.remove();
            }
        }

        ArrayList<String> list = new ArrayList<>(totalSet);
        HashSet<Integer> randomSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            int random = new Random().nextInt(list.size());
            while (randomSet.contains(random)) {
                random = (random + 1) % list.size();
            }
            randomSet.add(random);
            output[i] = list.get(random);
        }

        return output;
    }


}