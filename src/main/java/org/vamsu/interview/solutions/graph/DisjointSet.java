package org.vamsu.interview.solutions.graph;

import org.vamsu.interview.solutions.binarytree.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vamsu on 9/2/17.
 */
public class DisjointSet {

    private Map<Integer, Node> map;

    static class Node {
        Node parent;
        int data;
        int rank;

        public Node(Node parent, int data, int rank) {
            this.parent = parent;
            this.data = data;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Node{ parent=" + parent.data +
                    "data=" + data +
                    ", rank=" + rank +
                    '}';
        }
    }

    public DisjointSet() {
        this.map = new HashMap<>();
    }

    public Node makeSet(int data) {
        Node node = new Node(null, data, 0);
        node.parent = node;
        this.map.put(data, node);
        return node;
    }

    public void union(int data1, int data2) {
        Node n1Node = map.get(data1);
        Node n2Node = map.get(data2);

        Node parent1 = findSet(n1Node);
        Node parent2 = findSet(n2Node);

        if (parent1.data == parent2.data) {
            return;
        }
        if (parent1.rank == parent2.rank) {
            parent1.rank += 1;
        }
        if (parent1.rank > parent2.rank) {
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
    }

    public Integer findSet(int data) {
        return findSet(map.get(data)).data;
    }

    public Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return node;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }
}
