package org.vamsu.interview.solutions.binarytree;

/**
 * Created by vamsu on 8/23/17.
 */
public class ArrayToBTree {
    public static Node<Integer> toTree(int[] arr) {
        return toTree(arr, 0, arr.length - 1);
    }

    private static Node<Integer> toTree(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;

        Node<Integer> node = new Node<>(arr[mid], null, null);
        node.left = toTree(arr, start, mid - 1);
        node.right = toTree(arr, mid + 1, end);
        return node;
    }

    public static Node<Integer> toTree1(int[] arr) {
        return toTree1(arr, 0);
    }

    private static Node<Integer> toTree1(int[] arr, int index) {
        if (index >= arr.length) return null;
        Node<Integer> node = new Node<>(arr[index], null, null);
        node.left = toTree1(arr, 2 * index + 1);
        node.right = toTree1(arr, 2 * index + 2);
        return node;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 4, 7};
        Node<Integer> root = toTree1(arr);
        BTreePrinter.printNode(root);
    }

}
