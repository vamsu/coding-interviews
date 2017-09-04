package org.vamsu.interview.solutions.graph;

import java.util.*;

/**
 * Created by vamsu on 9/2/17.
 */
public class Graph {
    public boolean directed;
    public boolean weighted;
    public Set<Edge> allEdges;
    public Map<Integer, Vertex> allVertices;

    public Graph(boolean directed, boolean weighted) {
        this.allEdges = new HashSet<>();
        this.allVertices = new HashMap<>();
        this.directed = directed;
        this.weighted = weighted;
    }

    public void addEdge(Edge edge) {
        addEdge(edge.src.id, edge.dest.id, 0);
    }

    public void addEdge(int src, int dest) {
        addEdge(src, dest, 0);
    }

    public void addEdge(int src, int dest, int weight) {
        Vertex srcVertex = allVertices.get(src);
        if (srcVertex == null) {
            srcVertex = new Vertex(src);
            allVertices.put(src, srcVertex);
        }
        Vertex destVertex = allVertices.get(dest);
        if (destVertex == null) {
            destVertex = new Vertex(dest);
            allVertices.put(dest, destVertex);
        }
        allEdges.add(Edge.create(srcVertex, destVertex, this.directed, weight));
        srcVertex.addAdjacent(destVertex);
        if (!directed) {
            destVertex.addAdjacent(srcVertex);
        }
    }

    public int getEdgeWeight(int src, int dest) {
        for (Edge edge : allEdges) {
            if (edge.src.id == src && edge.dest.id == dest) {
                return edge.weight;
            }
        }
        return -1;
    }

    public Set<Edge> getVertexConnectedEdges(Vertex u) {
        Set<Edge> result = new HashSet<>();
        for (Edge edge : allEdges) {
            if (edge.src.equals(u)) {
                result.add(edge);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        if (weighted) {
            for (Edge edge : allEdges) {
                buffer.append(edge.src.id + "->" + edge.dest.id + " (" + edge.weight + ")\n");
            }
        } else {
            for (Vertex vertex : allVertices.values()) {
                buffer.append(vertex.id + "->");
                for (Vertex adj : vertex.adjacents) {
                    buffer.append(adj.id + ",");
                }
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }
}
