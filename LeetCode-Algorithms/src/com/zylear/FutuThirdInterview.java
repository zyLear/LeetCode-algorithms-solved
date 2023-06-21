package com.zylear;

import java.util.HashMap;
import java.util.Map;

public class FutuThirdInterview {

    public static void main(String[] args) {
        System.out.println(handle("abc","acbd"));
    }

    public static boolean handle(String s1, String s2) {

        Map<Character, Integer> map;
        for (int j = 0; j < s2.length(); j++) {
            map = initMap(s1);

            for (int i = 0; i < s2.length(); i++) {
                if (map.isEmpty()) {
                    return true;
                }
                char c = s2.charAt(i);
                Integer integer = map.get(c);
                if (integer == null || integer == 0) {
                    break;
                } else {
                    integer--;
                    if (integer == 0) {
                        map.remove(c);
                    } else {
                        map.put(c, integer);
                    }
                }
            }
        }

        return false;

    }

    private static Map<Character, Integer> initMap(String s1) {
        Map<Character, Integer> map = new HashMap<>();

        //init
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        return map;
    }

}
