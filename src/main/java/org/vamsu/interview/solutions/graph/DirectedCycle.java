package org.vamsu.interview.solutions.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vamsu on 9/2/17.
 */
public class DirectedCycle {

    public static boolean hasCycle(Graph graph) {
        Set<Vertex> whiteSet = new HashSet<>(graph.allVertices.values());
        Set<Vertex> graySet = new HashSet<>();
        Set<Vertex> blackSet = new HashSet<>();
        boolean hasCycle = false;
        while (whiteSet.size() > 0) {
            Vertex vertex = whiteSet.iterator().next();
            hasCycle = dfs(vertex, whiteSet, graySet, blackSet);
        }
        return hasCycle;
    }

    public static boolean dfs(Vertex current, Set<Vertex> whiteSet, Set<Vertex> graySet, Set<Vertex> blackSet) {
        moveVertex(current, whiteSet, graySet);
        for (Vertex neighbor : current.adjacents) {
            if (blackSet.contains(current)) {
                continue;
            }
            if (graySet.contains(neighbor)) {
                return true;
            }
            if (dfs(neighbor, whiteSet, graySet, blackSet)) {
                return true;
            }
        }
        moveVertex(current, graySet, blackSet);
        return false;
    }

    public static void moveVertex(Vertex vertex, Set<Vertex> src, Set<Vertex> dest) {
        src.remove(vertex);
        dest.add(vertex);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(true, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        System.out.println(graph);

        System.out.println("Has Cycle:" + hasCycle(graph));

        graph.addEdge(5, 0);
        System.out.println(graph);

        System.out.println("Has Cycle:" + hasCycle(graph));

    }
}
