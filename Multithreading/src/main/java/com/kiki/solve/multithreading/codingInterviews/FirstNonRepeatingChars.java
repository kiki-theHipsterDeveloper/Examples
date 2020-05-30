package com.kiki.solve.multithreading.codingInterviews;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChars {

    // To find first non repeating character in a string eg aaabcccd  --> b

    public static void main(String[] args) {
        String s ="aaabcccd";
        char[] args1 = s.toCharArray();

        Map<String, Integer> stringCount = new HashMap<>();

        for (char s1 : args1) {
            stringCount.merge(String.valueOf(s1),1,(integer, integer2) -> integer+integer2);
        }

        System.out.println(stringCount);

        for (char s1 : args1) {

            if (stringCount.get(String.valueOf(s1)) == 1) {
                System.out.println(s1);
                break;
            }
        }

    }
}
