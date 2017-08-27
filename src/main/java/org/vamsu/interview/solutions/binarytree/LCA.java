package org.vamsu.interview.solutions.binarytree;

/**
 * Created by vamsu on 8/26/17.
 */
public class LCA {

    public static Node<Integer> lca(Node<Integer> root, int x, int y) {
        if (root == null) {
            return null;
        }
        if (root.data == x || root.data == y) {
            return root;
        }
        Node<Integer> left = lca(root.left, x, y);
        Node<Integer> right = lca(root.right, x, y);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 7, 5, 6};
        Node<Integer> root = ArrayToBTree.toTree1(arr);
        BTreePrinter.printNode(root);
        System.out.println("LCA 1,6: " + lca(root, 1, 6).data);
        System.out.println("LCA 4,1: " + lca(root, 4, 1).data);
        System.out.println("LCA 4,1: " + lca(root, 6, 5).data);
        System.out.println("LCA 1,6: " + lca(root, 1, 12).data);
        System.out.println("LCA 4,1: " + lca(root, 5, 1).data);
    }
}
