package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

/**
 * DirectedGraph.java
 *
 * Created by Vineet Jain on 4/18/16.
 *
 * Representation of a Directed Graph that can have weighted edges, or
 * unweighted edges depending on the intended use. Uses an adjacency list to
 * keep track of edges.
 */
public class DirectedGraph<T> implements Graph<T>{

    private Hashtable<T, HashSet<T>> adjList;
    private int edgeCount;

    public DirectedGraph() {
        adjList = new Hashtable<T, HashSet<T>>();
        edgeCount = 0;
    }

    @Override
    public int numEdges() {
        return edgeCount;
    }

    @Override
    public int numVertices() {
        return adjList.size();
    }

    @Override
    public boolean isEdge(T src, T dst) {
        return adjList.contains(src) && adjList.get(src).contains(dst);
    }

    /**
     * Adds the edge (source, dest) with the specified weight
     *
     * @param src    the source node
     * @param dst    the destination node
     * @param weight weight of the edge
     */
    @Override
    public void addEdge(T src, T dst, int weight) {

    }

    /**
     * Gets all the nodes that are connected by 1 edge (neighbors) to the
     * parameter node
     *
     * @param node the node we want to get neighbors from
     * @return a List of nodes that are neighbors to the node of interest
     */
    @Override
    public List<T> getNeighbors(T node) {
        return null;
    }
}
