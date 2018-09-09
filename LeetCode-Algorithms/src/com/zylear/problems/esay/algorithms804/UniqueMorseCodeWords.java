package com.zylear.problems.esay.algorithms804;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiezongyu on 2018/9/8.
 */

/*      International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
        as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

        For convenience, the full table for the 26 letters of the English alphabet is given below:

        [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
        For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-").
        We'll call such a concatenation, the transformation of a word.

        Return the number of different transformations among all words we have.

        Example:
        Input: words = ["gin", "zen", "gig", "msg"]
        Output: 2
        Explanation:
        The transformation of each word is:
        "gin" -> "--...-."
        "zen" -> "--...-."
        "gig" -> "--...--."
        "msg" -> "--...--."

        There are 2 different transformations, "--...-." and "--...--.".


        Note:

        The length of words will be at most 100.
        Each words[i] will have length in range [1, 12].
        words[i] will only consist of lowercase letters.*/

public class UniqueMorseCodeWords {

    public static String[] stringToStringArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] words = stringToStringArray(line);

            int ret = new Solution().uniqueMorseRepresentations(words);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    static class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String morseList = "[\".-\",\"-...\",\"-.-.\",\"-..\",\".\",\"..-.\",\"--.\",\"....\",\"..\",\".---\",\"-.-\",\".-..\",\"--\",\"-.\",\"---\",\".--.\",\"--.-\",\".-.\",\"...\",\"-\",\"..-\",\"...-\",\".--\",\"-..-\",\"-.--\",\"--..\"]";
            JsonArray jsonValues = JsonArray.readFrom(morseList);
            String[] map = new String[jsonValues.size()];
            for (int i = 0; i < map.length; i++) {
                map[i] = jsonValues.get(i).asString();
            }
//        String[] morseCodes = new String[words.length];
            Set<String> set = new HashSet<>(words.length);
            for (int i = 0; i < words.length; i++) {
                StringBuilder morseCode = new StringBuilder();
                for (int j = 0; j < words[i].length(); j++) {
                    morseCode.append(map[words[i].charAt(j) - 'a']);
                }
                set.add(morseCode.toString());
            }
            return set.size();
        }
    }

}


