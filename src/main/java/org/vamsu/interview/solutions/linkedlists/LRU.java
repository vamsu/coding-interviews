package org.vamsu.interview.solutions.linkedlists;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vamsu on 8/28/17.
 */

class LRU {
    static class Node {
        String key;
        String value;
        Node previous;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<String, Node> cache;
    private int cap;
    private Node head;
    private Node tail;

    public LRU(int cap) {
        this.cap = cap;
        this.cache = new HashMap<>();
    }

    public static void main(String[] args) {
        LRU lru = new LRU(5);
        lru.put("t1", "");
        lru.put("t2", "");
        lru.print();
        lru.put("t3", "");
        lru.put("t4", "");
        lru.put("t5", "");
        lru.print();
        lru.get("t3");
        lru.print();
        lru.get("t1");
        lru.print();
        lru.get("t1");
        lru.print();
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.key + "->");
            current = current.next;
        }
        current = tail;
        System.out.print("|");
        String result = "";
        while (current != null) {
            result = current.key + "<-" + result;
            current = current.previous;
        }
        System.out.print(result);
        System.out.println();
    }
    public String get(String key) {
        if (!this.cache.containsKey(key)) {
            throw new RuntimeException();
        }
        Node current = this.cache.get(key);
        remove(current);
        addToLast(current);
        return current.value;
    }

    public void put(String key, String value) {
        if (this.cache.containsKey(key)) {
            Node current = this.cache.get(key);
            current.value = value;
            remove(current);
            addToLast(current);
        } else {
            Node newNode = new Node(key, value);
            if (this.cache.size() >= cap) {
                remove(head);
            }
            addToLast(newNode);
            this.cache.put(key, newNode);
        }
    }

    void addToLast(Node node) {
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            node.previous = tail;
            node.next = null;
            tail = node;
        }
    }

    void remove(Node node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        }
        if (node.next != null) {
            head = node.next;
            node.next.previous = node.previous;
        } else {
            head = null;
            tail = tail.previous;
        }
    }
}