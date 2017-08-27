package org.vamsu.interview.solutions.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by vamsu on 8/23/17.
 */
public class PreOrder {
    public static List<Integer> preOrder(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private static void preOrder(Node<Integer> root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public static List<Integer> preOrderIR(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<Integer> node = stack.pop();
            result.add(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 4, 8};
        Node<Integer> root = ArrayToBTree.toTree(arr);
        BTreePrinter.printNode(root);
        System.out.println("PreOrder recursive: " + Arrays.toString(preOrder(root).toArray()));
        System.out.println("PreOrder iterative: " + Arrays.toString(preOrderIR(root).toArray()));
    }
}
