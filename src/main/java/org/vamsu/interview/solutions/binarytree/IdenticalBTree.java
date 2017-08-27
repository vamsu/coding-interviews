package org.vamsu.interview.solutions.binarytree;

import java.util.Stack;

/**
 * Created by vamsu on 8/23/17.
 */
public class IdenticalBTree {

    static class Pair {
        Node a;
        Node b;

        Pair(Node a, Node b) {
            this.a = a;
            this.b = b;
        }
    }

    public static boolean isSame(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        return a != null && b != null &&
                a.data == b.data &&
                isSame(a.left, b.left) &&
                isSame(a.right, b.right);
    }

    public static boolean isSameIR(Node a, Node b) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(a, b));
        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            if (current.a == null && current.b == null) {
                continue;
            }
            if (current.a == null || current.b == null) {
                return false;
            }
            if (current.a.data != current.b.data) {
                return false;
            }
            stack.push(new Pair(current.a.left, current.b.left));
            stack.push(new Pair(current.a.right, current.b.right));
        }
        return true;
    }

    public static void main(String[] args) {
        int[] aArr = {1, 3, 4, 5, 7, 4, 7};
        Node<Integer> a = ArrayToBTree.toTree(aArr);
        Node<Integer> b = ArrayToBTree.toTree(aArr);
        BTreePrinter.printNode(a);
        BTreePrinter.printNode(b);
        System.out.println("Identical: " + isSame(a, b));
        System.out.println("Identical: " + isSameIR(a, b));

        int[] bArr = {1, 3, 4, 5, 7};
        Node<Integer> bNotSame = ArrayToBTree.toTree(bArr);
        BTreePrinter.printNode(a);
        BTreePrinter.printNode(bNotSame);
        System.out.println("Identical: " + isSame(a, bNotSame));
        System.out.println("Identical: " + isSameIR(a, bNotSame));

    }
}
