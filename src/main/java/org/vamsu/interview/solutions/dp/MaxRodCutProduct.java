package org.vamsu.interview.solutions.dp;

import java.util.Arrays;

/**
 * Created by vamsu on 8/21/17.
 */
public class MaxRodCutProduct {

    static int maxRodCutProduct(int n, String out) {
        out += " " + n;
        System.out.println( out);
        if (n <= 1) {
            return n;
        }
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            maxValue = Math.max(maxValue, i * maxRodCutProduct(n - i, out + " -->" ));
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(maxRodCutProduct(4, ""));
    }
}
