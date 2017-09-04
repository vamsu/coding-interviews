package org.vamsu.interview.solutions.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by vamsu on 9/2/17.
 */
public class TopologicalSort {

    public static String topological(Graph graph) {
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> discovered = new HashSet<>();

        for (Vertex u : graph.allVertices.values()) {
            if (!discovered.contains(u)) {
                dfs(u, stack, discovered);
            }
        }
        StringBuffer result = new StringBuffer();
        while (!stack.isEmpty()) {
            result.append(stack.pop().id + ",");
        }
        return result.toString();
    }

    private static void dfs(Vertex u, Stack<Vertex> stack, Set<Vertex> discovered) {
        discovered.add(u);
        for (Vertex v : u.adjacents) {
            if (!discovered.contains(v)) {
                dfs(v, stack, discovered);
            }
        }
        stack.push(u);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(true, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        System.out.println(graph);
        System.out.println(topological(graph));
    }

}
