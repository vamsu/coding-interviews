package org.vamsu.interview.solutions.recursion;

/**
 * Created by vamsu on 8/22/17.
 */
public class Substrings {
    static void print(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = 1; j < input.length() - i; j++) {
                System.out.println(input.substring(i, i + j));
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
