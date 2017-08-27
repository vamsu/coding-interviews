package org.vamsu.interview.solutions.binarytree;

/**
 * Created by vamsu on 8/23/17.
 */
public class HeightOfTree {
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 4, 7};
        Node<Integer> root = ArrayToBTree.toTree(arr);
        BTreePrinter.printNode(root);
        System.out.println("Height of the tree: " + height(root));
    }
}
