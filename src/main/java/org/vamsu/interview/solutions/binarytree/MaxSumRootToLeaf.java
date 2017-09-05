package org.vamsu.interview.solutions.binarytree;

import java.util.Stack;

/**
 * Created by vamsu on 8/26/17.
 */
public class MaxSumRootToLeaf {

    public static boolean printPath(Node<Integer> root, int sum) {
        if (sum == 0) {
            return true;
        }
        if (root == null) {
            return false;
        }
        boolean left = printPath(root.left, sum - root.data);
        boolean right = printPath(root.right, sum - root.data);

        if (left || right) {
            System.out.print(root.data + ",");
        }
        return left || right;
    }

    public static int maxSum(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        return Math.max(left, right) + root.data;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 2, 5, 7, 12, 8};
        Node<Integer> root = ArrayToBTree.toTree1(arr1);
        BTreePrinter.printNode(root);
        int sum = maxSum(root);
        System.out.println("Max Sum: " + sum);
        printPath(root, sum);
    }
}
