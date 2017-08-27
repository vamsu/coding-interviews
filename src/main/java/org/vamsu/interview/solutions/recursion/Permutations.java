package org.vamsu.interview.solutions.recursion;

import java.util.Arrays;

/**
 * Created by vamsu on 8/21/17.
 */
public class Permutations {
    static void printPermute(String input) {
        printPermute(input.toCharArray(), 0, input.length(),"");
    }

    static void printPermute(char[] input, int start, int end, String out) {
        if (start >= end) {
            System.out.println(Arrays.toString(input));
            return;
        } else {
            System.out.println(out + start + " " + Arrays.toString(input));
        }
        for (int i = start; i < end; i++) {
            swap(input, start, i);
            printPermute(input, start + 1, end, out + "-->");
            swap(input, start, i);
        }
    }

    static char[] swap(char[] input, int i, int j) {
        char cur = input[i];
        input[i] = input[j];
        input[j] = cur;
        return input;
    }

    public static void main(String[] args) {
        printPermute("abc");
    }
}
