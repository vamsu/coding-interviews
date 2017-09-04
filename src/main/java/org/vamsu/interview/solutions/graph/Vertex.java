package org.vamsu.interview.solutions.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vamsu on 9/2/17.
 */
public class Vertex {
    public int id;
    public int data;
    public Set<Vertex> adjacents;

    public Vertex(int id) {
        this.id = id;
        this.adjacents = new HashSet<>();
    }

    public Vertex(int id, int data) {
        this(id);
        this.data = data;
    }

    public void addAdjacent(Vertex adj) {
        this.adjacents.add(adj);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id:").append(id);
        builder.append(", adjs: ");
        for (Vertex adj : adjacents) {
            builder.append(adj.id).append(",");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (id != vertex.id) return false;
        return data == vertex.data;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + data;
        return result;
    }
}
