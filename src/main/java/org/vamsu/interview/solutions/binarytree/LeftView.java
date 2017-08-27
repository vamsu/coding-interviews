package org.vamsu.interview.solutions.binarytree;

import java.util.*;

/**
 * Created by vamsu on 8/26/17.
 */
public class LeftView {
    public static List<Integer> leftView(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean first = true;
            while (size-- != 0) {
                Node<Integer> current = queue.poll();
                if (first) {
                    result.add(current.data);
                    first = false;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 4, 8};
        Node<Integer> root = ArrayToBTree.toTree(arr);
        BTreePrinter.printNode(root);
        System.out.println("Left View: " + Arrays.toString(leftView(root).toArray()));
    }
}
