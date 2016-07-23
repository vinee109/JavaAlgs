package graph;

import java.util.List;

/**
 * Graph.java
 *
 * Created by Vineet Jain on 4/18/16.
 *
 * Defines an interface that all Graph classes should follow
 */
public interface Graph<T> {

    /**
     * Returns number of edges in this graph
     * @return the number of edges in the graph
     */
    int numEdges();

    /**
     * Returns the number of vertices in this graph
     * @return the number of verticies in the graph
     */
    int numVertices();

    /**
     * Check if the edge (source, dest) exists in this graph
     * @param src the source node
     * @param dst the destination node
     * @return true if the edge exists, false otherwise
     */
    boolean isEdge(T src, T dst);

    /**
     * Adds the edge (source, dest) with the specified weight
     * @param src the source node
     * @param dst the destination node
     * @param weight weight of the edge
     */
    void addEdge(T src, T dst, int weight);

    /**
     * Gets all the nodes that are connected by 1 edge (neighbors) to the
     * parameter node
     * @param node the node we want to get neighbors from
     * @return a List of nodes that are neighbors to the node of interest
     */
    List<T> getNeighbors(T node);

}
