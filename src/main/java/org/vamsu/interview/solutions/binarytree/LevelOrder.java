package org.vamsu.interview.solutions.binarytree;

import java.util.*;

/**
 * Created by vamsu on 8/23/17.
 */
public class LevelOrder {

    public static List<Integer> levelOrder(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        int level = 1;
        while (addLevel(root, level, result)) {
            level++;
        }
        return result;
    }

    private static boolean addLevel(Node<Integer> node, int level, List<Integer> result) {
        if (node == null) return false;
        if (level == 1) {
            System.out.println(node.data+",");
            result.add(node.data);
            return true;
        }
        boolean left = false;
        if (node.left != null) {
            left = addLevel(node.left, level - 1, result);
        }
        boolean right = false;
        if (node.right != null) {
            right = addLevel(node.right, level - 1, result);
        }
        return left || right;
    }

    public static List<Integer> levelOrderIR(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<Integer> current = queue.poll();
            result.add(current.data);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 4, 8};
        Node<Integer> root = ArrayToBTree.toTree(arr);
        BTreePrinter.printNode(root);
        System.out.println("LevelOrder recursive: " + Arrays.toString(levelOrder(root).toArray()));
        System.out.println("LevelOrder recursive: " + Arrays.toString(levelOrderIR(root).toArray()));
    }
}
