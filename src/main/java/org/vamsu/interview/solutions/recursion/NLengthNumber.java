package org.vamsu.interview.solutions.recursion;

import java.util.Arrays;

/**
 * Created by vamsu on 8/21/17.
 */
public class NLengthNumber {
    static void printNLength(int k, int n, int[] out, String op) {
        //System.out.println(op + "n=" + n);
        if (n <= 0) {
            System.out.println(Arrays.toString(out));
            return;
        }
        for (int i = 1; i <= k; i++) {
            out[n - 1] = i;
            printNLength(k, n - 1, out, op + "-->");
        }

    }

    public static void main(String[] args) {
        printNLength(3, 3, new int[3], "");
    }
}
