package org.vamsu.interview.solutions.graph;

import java.util.*;

/**
 * Created by vamsu on 8/31/17.
 */
public class UndirectedCycle {

    public static boolean hasCycle(Graph graph) {
        Set<Vertex> discovered = new HashSet<>();
        boolean hasCycle = false;
        for (Vertex u : graph.allVertices.values()) {
            if (!discovered.contains(u)) {
                hasCycle = hasCycle(graph.allVertices.get(0), null, discovered);
            }
            if (hasCycle) break;
        }
        return hasCycle;
    }

    private static boolean hasCycle(Vertex u, Vertex parent, Set<Vertex> discovered) {
        if (u == null) {
            return false;
        }
        discovered.add(u);
        for (Vertex v : u.adjacents) {
            if (!discovered.contains(v)) {
                return hasCycle(v, u, discovered);
            } else if (!v.equals(parent)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTree(Graph graph) {
        Set<Vertex> discovered = new HashSet<>();
        boolean isTree = !hasCycle(graph.allVertices.get(0), null, discovered);
        if (isTree) {
            for (Vertex u : graph.allVertices.values()) {
                if (!discovered.contains(u)) {
                    return false;
                }
            }
        }
        return isTree;
    }

    private static boolean hasCycleDS(Graph graph) {
        DisjointSet disjointSet = new DisjointSet();
        for (Vertex v : graph.allVertices.values()) {
            disjointSet.makeSet(v.id);
        }
        for (Edge edge : graph.allEdges) {
            Integer n1Parent = disjointSet.findSet(edge.src.id);
            Integer n2Parent = disjointSet.findSet(edge.dest.id);
            if (n1Parent.equals(n2Parent)) {
                return true;
            }
            disjointSet.union(edge.src.id, edge.dest.id);
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(false, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        System.out.println(graph);

        System.out.println("Is Tree:" + isTree(graph));
        System.out.println("Has Cycle (DFS):" + hasCycle(graph));
        System.out.println("Has Cycle (DisjointSet):" + hasCycleDS(graph));

        graph.addEdge(0, 5);
        System.out.println(graph);

        System.out.println("Is Tree:" + isTree(graph));
        System.out.println("Has Cycle (DFS):" + hasCycle(graph));
        System.out.println("Has Cycle (DisjointSet):" + hasCycleDS(graph));

    }
}
