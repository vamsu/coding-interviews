package org.vamsu.interview.solutions.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by vamsu on 8/26/17.
 */
public class InvertTree {

    public static void invert(Node<Integer> root) {
        if (root == null) {
            return;
        }
        swapLeftRight(root);
        invert(root.left);
        invert(root.right);
    }

    public static void swapLeftRight(Node<Integer> root) {
        Node<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void insertIR1(Node<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<Integer> current = queue.poll();
            swapLeftRight(current);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void insertIR2(Node<Integer> root) {
        if (root == null) {
            return;
        }
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<Integer> current = stack.pop();
            swapLeftRight(current);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 7, 5, 6};
        Node<Integer> root = ArrayToBTree.toTree1(arr);
        BTreePrinter.printNode(root);
        insertIR2(root);
        System.out.println("Inverted: ");
        BTreePrinter.printNode(root);
    }
}
