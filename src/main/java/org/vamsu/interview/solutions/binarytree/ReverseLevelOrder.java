package org.vamsu.interview.solutions.binarytree;

import java.util.*;

/**
 * Created by vamsu on 8/24/17.
 */
public class ReverseLevelOrder {

    public static List<Integer> reverseLevelOrderIR(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Queue<Node<Integer>> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<Integer> current = queue.poll();
            stack.add(current.data);
            if (current.right != null)
                queue.add(current.right);
            if (current.left != null)
                queue.add(current.left);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private static void preOrder(Node<Integer> root, int level, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        List<Integer> levelNodesData = map.get(level);
        if (levelNodesData == null) {
            levelNodesData = new ArrayList<>();
        }
        levelNodesData.add(root.data);
        map.put(level, levelNodesData);

        preOrder(root.left, level + 1, map);
        preOrder(root.right, level + 1, map);

    }

    public static List<Integer> reverseLevelOrderMap(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        preOrder(root, 1, levelMap);

        int height = 0;
        for (Integer currentHeight : levelMap.keySet()) {
            height = Math.max(height, currentHeight);
        }

        for (int i = height; i >= 1; i-- ){
            result.addAll(levelMap.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 4, 8};
        Node<Integer> root = ArrayToBTree.toTree(arr);
        BTreePrinter.printNode(root);
        System.out.println("LevelOrder iterative: " + Arrays.toString(reverseLevelOrderIR(root).toArray()));
        System.out.println("LevelOrder map approach: " + Arrays.toString(reverseLevelOrderMap(root).toArray()));
    }
}
