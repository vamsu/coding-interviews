package org.vamsu.interview.solutions.recursion;

import java.util.Arrays;

/**
 * Created by vamsu on 8/21/17.
 */
public class NLengthStrings {

    static void printNLength(char[] input, int n, char[] out, String pout) {
        System.out.println(pout + n + Arrays.toString(out));
        if (n <= 0) {
            System.out.println(out);
            return;
        }
        for (int i = 0; i < input.length; i++) {
            out[n - 1] = input[i];
            printNLength(input, n - 1, out, pout + "-->");
        }
    }

    public static void main(String[] args) {
        String input = "AB";
        printNLength(input.toCharArray(), 2, new char[2], "");
    }
}
