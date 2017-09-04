package org.vamsu.interview.solutions.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vamsu on 9/3/17.
 */
public class PhoneNumber {
    public static final char[][] keypad = {
            {'1'},
            {'1'},
            {'A', 'B', 'C'},
            {'D', 'E', 'F'},
            {'G', 'H', 'I'},
            {'J', 'K', 'L'},
            {'M', 'N', 'O'},
            {'P', 'Q', 'R', 'S'},
            {'T', 'U', 'V'},
            {'W', 'X', 'Y', 'Z'},
    };

    public static List<String> combinationsIR(int[] number) {
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        for (int i = 0; i < number.length; i++) {
            int digit = number[i];
            while (result.peek().length() == i) {
                String prefix = result.removeFirst();
                for (int j = 0; j < keypad[digit].length; j++) {
                    result.add(prefix + keypad[digit][j]);
                }
            }
        }
        return result;
    }

    public static void combinations(int[] number, char[] res, int index) {
        if (index >= res.length) {
            System.out.print(new String(res) + ",");
            return;
        }
        int digit = number[index];
        int len = keypad[digit].length;
        for (int i = 0; i < len; i++) {
            res[index] = keypad[digit][i];
            combinations(number, res, index + 1);
        }
    }

    public static List<String> letterCombinations(int[] input) {
        List<String> ret = new LinkedList<>();
        combination("", input, 0, ret);
        return ret;
    }

    private static void combination(String prefix, int[] input, int index, List<String> ret) {
        if (index >= input.length) {
            ret.add(prefix);
            return;
        }
        String letters = new String(keypad[input[index]]);
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), input, index + 1, ret);
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 4};
        System.out.println(letterCombinations(input));
        System.out.println(combinationsIR(input));
        combinations(input, new char[input.length], 0);
    }
}
