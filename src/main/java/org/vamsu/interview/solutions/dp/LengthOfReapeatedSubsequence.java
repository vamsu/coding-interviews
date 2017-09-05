package org.vamsu.interview.solutions.dp;

/**
 * Created by vamsu on 8/22/17.
 */
public class LengthOfReapeatedSubsequence {

    static int maxLRS(String a, String b, int aIndex, int bIndex) {
        if (aIndex <= 0 || bIndex <= 0) {
            return 0;
        }
        if (a.charAt(aIndex - 1) == b.charAt(bIndex - 1) && aIndex != bIndex) {
            return 1 + maxLRS(a, b, aIndex - 1, bIndex - 1);
        }
        return Math.max(maxLRS(a, b, aIndex, bIndex - 1), maxLRS(a, b, aIndex - 1, bIndex));
    }

    static int maxLRSDP(String a, String b) {
        int max = 0;
        int[][] tracker = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1) && i != j) {
                    tracker[i][j] = 1 + tracker[i - 1][j - 1];
                } else {
                    tracker[i][j] = Math.max(tracker[i - 1][j], tracker[i][j - 1]);
                }
                max = Math.max(tracker[i][j], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String a = "ATACTCGGA";
        String b = "ATACTCGGA";
        System.out.println(maxLRS(a, b, a.length(), b.length()));
        System.out.println(maxLRSDP(a, b));
    }
}
