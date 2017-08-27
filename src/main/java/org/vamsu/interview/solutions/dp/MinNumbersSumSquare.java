package org.vamsu.interview.solutions.dp;

/**
 * Created by vamsu on 8/21/17.
 */
public class MinNumbersSumSquare {
    static int minValues(int sum) {
        int options = (int) Math.sqrt(sum);
        return minValues(sum, options, "");
    }

    static int minValues(int sum, int options, String out) {
        System.out.println(out + " " + sum );
        if (sum <= 0) {
            return 0;
        }
        int values = Integer.MAX_VALUE;
        for (int i = 1; i <= options && sum >= i * i; i++) {
            values = Math.min(values, minValues(sum - i * i, options, out + "-->"));
        }
        return values + 1;
    }

    public static void main(String[] args) {
        System.out.println(minValues(12));
    }
}
