package org.vamsu.interview.solutions.dp;

/**
 * Created by vamsu on 8/21/17.
 */
public class LengthOfLCSubString {

    static int maxLCSDP(String a, String b) {
        int max = 0;
        int[][] tracker = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    tracker[i][j] = 1 + tracker[i - 1][j - 1];
                    max = Math.max(tracker[i][j], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String a = "tutorialhorizon";
        String b = "dynamictutorialProgramming";
        System.out.println(maxLCSDP(a, b));
    }
}
