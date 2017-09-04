package org.vamsu.interview.solutions.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by vamsu on 9/4/17.
 */
public class FirstKNonRepeating {

    public static List<Character> solve(String input, int k) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (map.get(input.charAt(i)) == null) {
                map.put(input.charAt(i), 1);
                list.add(input.charAt(i));
            } else {
                list.remove(Character.valueOf(input.charAt(i)));
            }
        }
        return list.subList(0, k);
    }

    public static void main(String[] args) {
        System.out.println(solve("ABCDBAGHCHFAC", 3));
    }
}
