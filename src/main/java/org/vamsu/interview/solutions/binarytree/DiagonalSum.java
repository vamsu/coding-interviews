package org.vamsu.interview.solutions.binarytree;

import java.util.*;

/**
 * Created by vamsu on 8/26/17.
 */
public class DiagonalSum {
    public static List<Integer> diagonalSum(Node<Integer> root) {
        Map<Integer, Integer> diagSum = new HashMap<>();
        diagonalSum(root, 0, diagSum);
        List<Integer> result = new ArrayList<>();
        for (Integer sum : diagSum.values()) {
            result.add(sum);
        }
        return result;
    }

    public static void diagonalSum(Node<Integer> root, int diag, Map<Integer, Integer> diagSum) {
        if (root == null) {
            return;
        }
        Integer sum = diagSum.containsKey(diag) ? diagSum.get(diag) : 0;
        diagSum.put(diag, sum + root.data);

        diagonalSum(root.left, diag + 1, diagSum);
        diagonalSum(root.right, diag, diagSum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 4, 7};
        Node<Integer> root = ArrayToBTree.toTree(arr);
        BTreePrinter.printNode(root);
        System.out.println("Diagonal Sum: " + Arrays.toString(diagonalSum(root).toArray()));
    }
}
