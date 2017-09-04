package org.vamsu.interview.solutions.graph;

import java.util.*;

/**
 * Created by vamsu on 9/2/17.
 */
public class KruskasMST {

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return Integer.compare(o1.weight, o2.weight);
        }
    }

    public static String mst(Graph graph) {
        List<Edge> sortedEdges = new ArrayList<>(graph.allEdges);
        sortedEdges.sort(new EdgeComparator());

        for (Edge edge : sortedEdges) {
            System.out.println(edge.src.id + "->" + edge.dest.id + " (" + edge.weight + ")");
        }

        DisjointSet disjointSet = new DisjointSet();
        for (Vertex vertex : graph.allVertices.values()) {
            disjointSet.makeSet(vertex.id);
        }

        StringBuilder buffer = new StringBuilder();
        for (Edge edge : sortedEdges) {
            int parent1 = disjointSet.findSet(edge.src.id);
            int parent2 = disjointSet.findSet(edge.dest.id);
            if (parent1 != parent2) {
                buffer.append(edge.src.id).append("->").append(edge.dest.id).append(",");
                disjointSet.union(parent1, parent2);
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(false, true);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);
        graph.addEdge(4, 6, 6);
        graph.addEdge(5, 6, 2);

        System.out.println(graph);
        System.out.println(mst(graph));
    }

}
