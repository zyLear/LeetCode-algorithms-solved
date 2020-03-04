package com.zylear.problems.test;

import java.util.*;

/**
 * Created by xiezongyu on 2020/2/22.
 */
public class SortTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "e", "d", "c"));

        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 2, 4, 5, null, null));

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(10, 0.75F, false);

        TreeSet<String> set = new TreeSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        for (String string : list) {

            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }

            if (!set.contains(string)) {
                set.add(string);
            }

            if (!linkedHashSet.contains(string)) {
                linkedHashSet.add(string);
            }
        }
        System.out.println(map);
        System.out.println(set);
        System.out.println(linkedHashSet);


        list2.sort(Integer::compareTo);


        System.out.println(list2);
    }


}
