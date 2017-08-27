package org.vamsu.interview.solutions.binarytree;

import java.util.Arrays;

/**
 * Created by vamsu on 8/26/17.
 */
public class SumTree {

    public static int convertToSumTree(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = convertToSumTree(root.left);
        int right = convertToSumTree(root.right);

        int previous = root.data;

        root.data = left + right;
        return root.data + + previous;
    }

    public static boolean isSumTree(Node<Integer> root) {
        if (root == null) {
            return true;
        }
        return isSumTreeSub(root) != Integer.MIN_VALUE;
    }

    public static int isSumTreeSub(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }

        if (root.data == isSumTreeSub(root.left) + isSumTreeSub(root.right))
            return 2 * root.data;

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 4, 8};
        Node<Integer> root = ArrayToBTree.toTree(arr);
        System.out.println("Before Conversion:");
        BTreePrinter.printNode(root);

        convertToSumTree(root);
        System.out.println("Converted Sum Tree:");
        BTreePrinter.printNode(root);
        System.out.println("IsSum Tree: " + isSumTree(root));

        int[] arr1 = {4, 9, 5, 44, 6, 13, 7};
        Node<Integer> sumTree = ArrayToBTree.toTree(arr1);
        System.out.println("Sum Tree:");
        BTreePrinter.printNode(sumTree);
        System.out.println("IsSum Tree: " + isSumTree(sumTree));

        sumTree.data = 1;
        BTreePrinter.printNode(sumTree);
        System.out.println("IsSum Tree: " + isSumTree(sumTree));
    }
}
