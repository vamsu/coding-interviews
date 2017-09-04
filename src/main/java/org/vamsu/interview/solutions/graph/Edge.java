package org.vamsu.interview.solutions.graph;

/**
 * Created by vamsu on 9/2/17.
 */
public class Edge {
    public Vertex src;
    public Vertex dest;
    public boolean directed;
    public int weight;

    private Edge(Vertex src, Vertex dest, boolean directed, int weight) {
        this.src = src;
        this.dest = dest;
        this.directed = directed;
        this.weight = weight;
    }

    public static Edge create(Vertex src, Vertex dest) {
        return new Edge(src, dest, false, 0);
    }

    public static Edge create(Vertex src, Vertex dest, boolean directed) {
        return new Edge(src, dest, directed, 0);
    }

    public static Edge create(Vertex src, Vertex dest, boolean directed, int weight) {
        return new Edge(src, dest, false, weight);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", dest=" + dest +
                ", directed=" + directed +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (directed != edge.directed) return false;
        if (weight != edge.weight) return false;
        if (src != null ? !src.equals(edge.src) : edge.src != null) return false;
        return dest != null ? dest.equals(edge.dest) : edge.dest == null;
    }

    @Override
    public int hashCode() {
        int result = src != null ? src.hashCode() : 0;
        result = 31 * result + (dest != null ? dest.hashCode() : 0);
        result = 31 * result + (directed ? 1 : 0);
        result = 31 * result + weight;
        return result;
    }
}
