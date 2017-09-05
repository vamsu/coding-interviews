package org.vamsu.interview.solutions.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vamsu on 8/21/17.
 */
public class Permutations {
    static void printPermute(String input) {
        printPermute(input.toCharArray(), 0, input.length(), "");
    }

    static void printPermute(char[] input, int start, int end, String out) {
        if (start >= end) {
            System.out.println(Arrays.toString(input));
            return;
        } else {
            //System.out.println(out + start + " " + Arrays.toString(input));
        }
        for (int i = start; i < end; i++) {
            swap(input, start, i);
            printPermute(input, start + 1, end, out + "-->");
            swap(input, start, i);
        }
    }

    static void allPermute(char[] input, char[] res, int index) {
        if (index >= res.length) {
            System.out.println(new String(res));
            return;
        }
        for (int i = 0; i < input.length; i++) {
            res[index] = input[i];
            allPermute(input, res, index + 1);
        }
    }

    static void permute(char[] input, char[] res, int index) {
        if (index <= 0) {
            System.out.println(new String(res));
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (res[i] == '?') {
                res[i] = input[index - 1];
                permute(input, res, index - 1);
                res[i] = '?';
            }
        }
    }

    static char[] swap(char[] input, int i, int j) {
        char cur = input[i];
        input[i] = input[j];
        input[j] = cur;
        return input;
    }

    public static void nonOverlapping(String input, List<String> out) {
        if (input.length() == 0) {
            System.out.println(Arrays.toString(out.toArray()));
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            String substring = input.substring(0, i + 1);
            out.add(substring);
            nonOverlapping(input.substring(i + 1), out);
            out.remove(substring);
        }
    }

    public static void main(String[] args) {
        //printPermute("abcd");
        //allPermute("abcd".toCharArray(), new char[4], 0);
        //char[] res = {'?', '?', '?', '?'};
        //permute("abcd".toCharArray(), res, 4);
        nonOverlapping("abcd", new ArrayList<>());
    }
}
