package org.vamsu.interview.solutions.utils;

import org.vamsu.interview.solutions.linkedlists.ListNode;

public class ListNodeUtils {
    public static ListNode create(int[] arr) {
        if (arr.length <= 0) {
            return null;
        }
        ListNode root = new ListNode(arr[0]);
        ListNode node = root;
        for (int i = 1; i < arr.length; i++) {
            if (node == null) {
                node = new ListNode(arr[i]);
            } else {
                node.next = new ListNode(arr[i]);
                node = node.next;
            }
        }
        return root;
    }
}
