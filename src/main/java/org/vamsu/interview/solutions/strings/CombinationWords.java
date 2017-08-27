package org.vamsu.interview.solutions.strings;

/**
 * Created by vamsu on 8/26/17.
 */
public class CombinationWords {

    static String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static void combinations(int[] digits, int start, int end, String out) {
        if (start == end) {
            System.out.println(out);
            return;
        }
        int sum = 0;
        for (int i = start; i <= Math.min(start + 1, end - 1); i++) {
            sum = (sum * 10) + digits[i];
            if (sum <= 26)
                combinations(digits, i + 1, end, out + ALPHABETS.charAt(sum - 1));
        }
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 2};
        combinations(digits, 0, digits.length, "");
    }
}
