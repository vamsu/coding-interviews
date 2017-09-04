package org.vamsu.interview.solutions.recursion;

/**
 * Created by vamsu on 9/3/17.
 */
public class WildCardCombinations {

    public static void combinations(char[] input, int index) {
        if (index >= input.length) {
            System.out.println(input);
            return;
        }
        if (input[index] == '?') {
            for (int i = 0; i < 2; i++) {
                input[index] = (char) (i + '0');
                combinations(input, index + 1);
                input[index] = '?';
            }
        } else {
            combinations(input, index + 1);
        }
    }

    public static void main(String[] args) {
        combinations("1?11?00?1?1".toCharArray(), 0);
    }
}
