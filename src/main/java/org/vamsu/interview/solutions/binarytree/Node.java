package org.vamsu.interview.solutions.binarytree;

/**
 * Created by vamsu on 8/23/17.
 */
public class Node<T> {
    T data;
    Node<T> left, right;

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int size() {
        return 1 + ((this.left == null) ? 0 : this.left.size()) +
                ((this.right == null) ? 0 : this.right.size());
    }
}

