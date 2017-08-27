package org.vamsu.interview.solutions.binarytree;

import java.util.*;

/**
 * Created by vamsu on 8/26/17.
 */
public class TopView {
    static class Pair {
        int level;
        int data;

        public Pair(int level, int data) {
            this.level = level;
            this.data = data;
        }
    }


    public static List<Integer> topView(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Pair> map = new HashMap<>();
        topView(root, map, 0, 1);

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (Integer dist : keys) {
            result.add(map.get(dist).data);
        }
        return result;
    }

    public static void topView(Node<Integer> root, Map<Integer, Pair> map, int dist, int level) {
        if (root == null) {
            return;
        }
        if (map.get(dist) == null || level <= map.get(dist).level) {
            map.put(dist, new Pair(level, root.data));
        }
        topView(root.left, map, dist - 1, level + 1);
        topView(root.right, map, dist + 1, level + 1);
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 4, 8};
        Node<Integer> root = ArrayToBTree.toTree(arr);
        BTreePrinter.printNode(root);
        System.out.println("Top View: " + Arrays.toString(topView(root).toArray()));
    }
}
