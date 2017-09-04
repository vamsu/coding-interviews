package org.vamsu.interview.solutions.arrays;

/**
 * Created by vamsu on 9/3/17.
 */
public class ColumnName {

    public static Integer toColumnNumber(String name) {
        int n = name.length() - 1;
        int result = 0;
        for (Character ch : name.toCharArray()) {
            int current = (ch - 'A') + 1;
            result += current * Math.pow(26, n);
            n--;
        }
        return result;
    }

    public static String toColumnName(Integer number) {
        String result = "";
        while (number > 0) {
            int index = (number - 1) % 26;
            result = String.valueOf((char) (index + 'A')) + result;
            number = (number - 1) / 26;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("CA " + toColumnNumber("CA"));
        System.out.println("FH " + toColumnNumber("FH"));
        System.out.println("AFA " + toColumnNumber("AFA"));
        System.out.println("KJ " + toColumnNumber("KJ"));
        System.out.println("833 " + toColumnName(833));

    }
}
