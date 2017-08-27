package org.vamsu.interview.solutions.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by vamsu on 8/23/17.
 */
public class InOrder {
    public static List<Integer> inOrder(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private static void inOrder(Node<Integer> root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static List<Integer> inOrderIR(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node<Integer>> stack = new Stack<>();
        Node<Integer> current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.data);
                current = current.right;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 4, 8};
        Node<Integer> root = ArrayToBTree.toTree(arr);
        BTreePrinter.printNode(root);
        System.out.println("InOrder recursive: " + Arrays.toString(inOrder(root).toArray()));
        System.out.println("InOrder iterative: " + Arrays.toString(inOrderIR(root).toArray()));
    }
}
