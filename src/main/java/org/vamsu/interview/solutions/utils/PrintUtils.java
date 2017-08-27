package org.vamsu.interview.solutions.utils;

import org.vamsu.interview.solutions.linkedlists.ListNode;

public class PrintUtils {
    public static void prettyPrint(String prefix, int[] arr) {
        StringBuffer buffer = new StringBuffer();
        System.out.print(prefix + ": ");
        buffer.append(buffer);
        buffer.append(": ");
        for (int i = 0; i < arr.length; i++) {
            buffer.append(arr[i]);
            buffer.append(",");
        }
        System.out.println(buffer);
    }

    public static void prettyPrint(String prefix, ListNode node) {
        StringBuffer buffer = new StringBuffer();
        System.out.print(prefix + ": ");
        while (node != null) {
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }
    }

    public static void prettyPrint(String prefix, int[][] input) {
        System.out.println(prefix + ": ");
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
}
