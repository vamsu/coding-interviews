package org.vamsu.interview.solutions.binarytree;

import java.util.*;

/**
 * Created by vamsu on 8/23/17.
 */
public class PostOrder {

    public static List<Integer> postOrder(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private static void postOrder(Node<Integer> root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.data);
    }

    public static List<Integer> postOrderIR(Node<Integer> root) {
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> result = new Stack<>();
        while (!stack.isEmpty()) {
            Node<Integer> current = stack.pop();
            result.push(current.data);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        List<Integer> finalResult = new ArrayList<>(result);
        Collections.reverse(finalResult);
        return finalResult;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 4, 8};
        Node<Integer> root = ArrayToBTree.toTree(arr);
        BTreePrinter.printNode(root);
        System.out.println("PostOrder recursive: " + Arrays.toString(postOrder(root).toArray()));
        System.out.println("PostOrder iterative: " + Arrays.toString(postOrderIR(root).toArray()));
    }
}
