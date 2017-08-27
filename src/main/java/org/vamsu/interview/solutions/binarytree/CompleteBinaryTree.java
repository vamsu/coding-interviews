package org.vamsu.interview.solutions.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vamsu on 8/26/17.
 */
public class CompleteBinaryTree {

    public static boolean isComplete1(Node<Integer> root) {
        if (root == null) {
            return true;
        }
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int previousLevelSize = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int actualLevelSize = 0;
            while (size-- != 0) {
                Node<Integer> current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                    actualLevelSize++;
                }
                if (current.right != null) {
                    queue.add(current.right);
                    actualLevelSize++;
                }
            }
            if (actualLevelSize != 0 && previousLevelSize * 2 != actualLevelSize) {
                return false;
            }
            previousLevelSize = actualLevelSize;
        }
        return true;
    }

    public static boolean isComplete2(Node<Integer> root) {
        if (root == null) {
            return true;
        }
        int size = root.size();
        boolean[] tracker = new boolean[size];
        populateTracker(root, tracker, 0, size);

        for (boolean trackNode : tracker) {
            if (!trackNode) {
                return false;
            }
        }

        return true;
    }

    static void populateTracker(Node<Integer> root, boolean[] tracker, int i, int n) {
        if (root == null) {
            return;
        }
        tracker[i] = true;
        if (root.left != null) {
            populateTracker(root.left, tracker, 2 * i + 1, n);
        }
        if (root.right != null) {
            populateTracker(root.left, tracker, 2 * i + 2, n);
        }
    }

    public static boolean isComplete3(Node<Integer> root) {
        if (root == null) {
            return true;
        }
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node<Integer> current = queue.poll();
            boolean leafLevel = false;
            while (size-- != 0) {
                if (current.left == null || current.right == null) {
                    leafLevel = true;
                }
                if (current.left != null) {
                    if (leafLevel) {
                        return false;
                    }
                    queue.add(current.left);
                }
                if (current.right != null) {
                    if (leafLevel) {
                        return false;
                    }
                    queue.add(current.right);
                }

            }
        }
        return true;
    }

    public static boolean isComplete4(Node<Integer> root) {
        if (root == null) {
            return true;
        }
        return isComplete4(root, 0, root.size());
    }

    static boolean isComplete4(Node<Integer> root, int i, int n) {
        if (root == null) {
            return true;
        }
        if ((root.left != null && 2 * i + 1 >= n) || !isComplete4(root.left, 2 * i + 1, n)) {
            return false;
        }
        if ((root.right != null && 2 * i + 2 >= n) || !isComplete4(root.right, 2 * i + 2, n)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 2, 5, 7, 4, 8};
        Node<Integer> root1 = ArrayToBTree.toTree(arr1);
        BTreePrinter.printNode(root1);
        System.out.println("Complete BT: " + isComplete1(root1));
        System.out.println("Complete BT: " + isComplete2(root1));
        System.out.println("Complete BT: " + isComplete3(root1));
        System.out.println("Complete BT: " + isComplete4(root1));

        int[] arr2 = {1, 3, 2, 5, 7, 4};
        Node<Integer> root2 = ArrayToBTree.toTree(arr2);
        BTreePrinter.printNode(root2);
        System.out.println("Complete BT: " + isComplete1(root2));
        System.out.println("Complete BT: " + isComplete2(root2));
        System.out.println("Complete BT: " + isComplete3(root2));
        System.out.println("Complete BT: " + isComplete4(root2));
    }
}
