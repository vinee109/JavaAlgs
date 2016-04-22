package graph;

/**
 * Node.java
 *
 * Created by Vineet Jain on 4/22/16.
 *
 * Encapsulates items into Node objects to be represented within
 * the Graph
 */
public class Node<T> {
    private T item;     // the item to be encapsulated

    public Node(T item){
        this.item = item;
    }

    /**
     * Getter for the encapsulated item
     * @return the item that this Node encapsulates
     */
    public T getItem() {
        return item;
    }

    @Override
    public int hashCode() {
        return item.hashCode();
    }
}
