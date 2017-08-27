package org.vamsu.interview.solutions.dp;

import java.util.Arrays;

/**
 * Created by vamsu on 8/21/17.
 */
public class NonConsecutive1 {

    static int nonConsecutive1(int n, int lastDigit, String out) {
        out += " " + n;
        System.out.println(out);
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            if (lastDigit == 1) return 1;
            else if (lastDigit == 0) return 2;
        }
        if (lastDigit == 0) {
            return nonConsecutive1(n - 1, 0, out + " -->") +
                    nonConsecutive1(n - 1, 1, out + " -->");
        } else {
            return nonConsecutive1(n - 1, 0, out + " -->");
        }

    }

    static int countAll(int n, String out) {
        out += " " + n;
        System.out.println(out);
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 2;
        }
        return countAll(n - 1, out + " -->") +
                countAll(n - 1, out + " -->");

    }

    static void generate(int n, int[] result, String out) {
        out += " " + n;
        System.out.println(out + " " + Arrays.toString(result));
        if (n <= 0) {
            System.out.println(Arrays.toString(result));
            return;
        }
        result[n - 1] = 0;
        generate(n - 1, result, out + " -->");
        result[n - 1] = 1;
        generate(n - 1, result, out + " -->");

    }


    public static void main(String[] args) {
        System.out.println(nonConsecutive1(5, 0, ""));
        System.out.println(countAll(5, ""));
        generate(5, new int[5], "");
    }
}
