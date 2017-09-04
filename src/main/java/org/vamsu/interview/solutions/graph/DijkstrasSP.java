package org.vamsu.interview.solutions.graph;

import java.util.*;

/**
 * Created by vamsu on 9/3/17.
 */
public class DijkstrasSP {

    public static class QueueComparator implements Comparator<Vertex> {
        @Override
        public int compare(Vertex o1, Vertex o2) {
            return Integer.compare(o1.id, o2.id);
        }
    }

    public static String shortestPath(Graph graph) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(new QueueComparator());
        Vertex initial = graph.allVertices.get(1);
        priorityQueue.add(initial);

        Map<Vertex, Integer> vertexDistance = new HashMap<>();
        for (Vertex vertex : graph.allVertices.values()) {
            vertexDistance.put(vertex, Integer.MAX_VALUE);
        }
        vertexDistance.put(initial, 0);

        Map<Vertex, Vertex> previous = new HashMap<>();

        Set<Vertex> visited = new HashSet<>();
        visited.add(initial);
        while (!priorityQueue.isEmpty()) {
            Vertex u = priorityQueue.poll();
            for (Vertex v : u.adjacents) {
                int weight = graph.getEdgeWeight(u.id, v.id);
                if (!visited.contains(v) && (vertexDistance.get(u) + weight < vertexDistance.get(v))) {
                    vertexDistance.put(v, vertexDistance.get(u) + weight);
                    priorityQueue.add(v);
                    previous.put(v, u);
                }
            }
            visited.add(u);
        }
        StringBuilder buffer = new StringBuilder();
        for (Vertex vertex : graph.allVertices.values()) {
            List<Vertex> result = new LinkedList<>();
            result.add(vertex);
            Vertex prev = previous.get(vertex);
            while (prev != null) {
                result.add(prev);
                prev = previous.get(prev);
            }
            Collections.reverse(result);
            for (Vertex v : result) {
                buffer.append(v.id).append("->");
            }
            buffer.append("(").append(vertexDistance.get(vertex)).append(")\n");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(true, true);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 5, 3);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 3, 7);
        graph.addEdge(5, 2, 1);
        graph.addEdge(5, 3, 8);

        System.out.println(graph);
        System.out.println(shortestPath(graph));
    }
}
