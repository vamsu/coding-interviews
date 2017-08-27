package org.vamsu.interview.solutions.dp;

import java.util.HashSet;

/**
 * Created by vamsu on 8/20/17.
 */
public class WordBreak {

    static void printPossible(String input, HashSet<String> hs, String out) {
        if (input.length() == 0) {
            System.out.println(out);
            return;
        }
        for (int i = 1; i <= input.length(); i++) {
            String prefix = input.substring(0, i);
            if (hs.contains(prefix)) {
                printPossible(input.substring(i), hs, out + " " + prefix);
            }
        }
    }

    static boolean canBeBroken(String input, HashSet<String> hs) {
        if (input.length() == 0) {
            return true;
        }
        for (int i = 1; i <= input.length(); i++) {
            String prefix = input.substring(0, i);
            if (hs.contains(prefix) && canBeBroken(input.substring(i), hs)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("this");
        hs.add("is");
        hs.add("thi");
        hs.add("sis");
        hs.add("sumit");
        hs.add("jain");
        hs.add("the");
        hs.add("problem");
        String input = "thisissumitjain";

        System.out.println(canBeBroken(input, hs));
        printPossible(input, hs,"");
    }
}
