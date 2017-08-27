package org.vamsu.interview.solutions.recursion;

/**
 * Created by vamsu on 8/22/17.
 */
public class Substrings {
    static void print(String input) {
        for (int c = 0; c < input.length(); c++) {
            for (int i = 1; i <= input.length() - c; i++) {
                System.out.println(input.substring(c, c + i));
            }
        }
    }

    static void print(int[] arr) {
        for (int c = 0; c < arr.length; c++) {
            for (int i = 1; i <= arr.length - c; i++) {
                for (int k = c; k < c + i; k++) {
                    System.out.print(arr[k] + ",");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        print(arr);
        print("abcd");

    }
}
