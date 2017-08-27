package org.vamsu.interview.solutions.dp;

/**
 * Created by vamsu on 8/20/17.
 */
public class NumberOfSteps {

    public static int possibleWays(int steps) {
        if (steps <= 0) {
            return 0;
        }
        return 1 + possibleWays(steps - 1) + possibleWays(steps - 2) + possibleWays(steps - 3);
    }

    public static int possibleWaysDP(int steps) {
        if (steps <= 0) {
            return 0;
        }
        if (steps == 1) return  1;
        int ways[] = {1, 1, 2};
        for (int i = 3; i <= steps; i++) {
            int count = ways[0] + ways[1] + ways[2];
            ways[0] = ways[1];
            ways[1] = ways[2];
            ways[2] = count;
        }
        return ways[2];
    }

    public static void main(String[] args) {
        System.out.println(possibleWays(3));
        System.out.println(possibleWaysDP(3));
    }
}
