package org.vamsu.interview.solutions.strings;

/**
 * Created by vamsu on 6/10/17.
 */
public class AnagramChecker {

    public boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException();
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int retval = 0;
        for (int i = 0; i < s1.length(); i++)
            retval = retval ^ s1.charAt(i);

        for (int k = 0; k < s2.length(); k++)
            retval = retval ^ s2.charAt(k);

        return retval == 0;
    }

    public static void main(String[] args) {
        AnagramChecker checker = new AnagramChecker();
        System.out.println(checker.isAnagram("foobar", "barfoo"));
        System.out.println(checker.isAnagram("foobar", "barfoo1"));
        System.out.println(checker.isAnagram("fff", "fff"));
        System.out.println(checker.isAnagram("foobar", null));
    }
}
