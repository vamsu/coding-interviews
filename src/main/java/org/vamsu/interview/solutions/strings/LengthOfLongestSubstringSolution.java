package org.vamsu.interview.solutions.strings;

public class LengthOfLongestSubstringSolution {

    public static void main(String args[]) {
        LengthOfLongestSubstringSolution lengthOfLongestSubstringSolution = new LengthOfLongestSubstringSolution();
        int result = lengthOfLongestSubstringSolution.solve("abcabcbb");
        System.out.println("LengthOfLongestSubstringSolution Result: " + result);

        result = lengthOfLongestSubstringSolution.solve("bbbbbb");
        System.out.println("LengthOfLongestSubstringSolution Result: " + result);

        result = lengthOfLongestSubstringSolution.solve("pwwkew");
        System.out.println("LengthOfLongestSubstringSolution Result: " + result);

        result = lengthOfLongestSubstringSolution.solve("c");
        System.out.println("LengthOfLongestSubstringSolution Result: " + result);

        result = lengthOfLongestSubstringSolution.solve("dvdf");
        System.out.println("LengthOfLongestSubstringSolution Result: " + result);
    }

    public int solve(String s) {
        return -1;
    }
}
