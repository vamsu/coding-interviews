package org.vamsu.interview.solutions.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vamsu on 8/26/17.
 */
public class PrintAllPaths {

    public static List<List<Integer>> paths(Node<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        paths(root, new Integer[3], 0, result);
        return result;
    }

    public static void paths(Node<Integer> root, Integer path[], int pathLen, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path[pathLen] = root.data;
        pathLen++;
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(Arrays.asList(path)));
            return;
        }
        paths(root.left, path, pathLen, result);
        paths(root.right, path, pathLen, result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 4, 8};
        Node<Integer> root = ArrayToBTree.toTree(arr);
        BTreePrinter.printNode(root);

        for (List<Integer> path : paths(root)) {
            System.out.println(Arrays.toString(path.toArray()));
        }
    }
}
