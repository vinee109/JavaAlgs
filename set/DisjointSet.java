package set;

/**
 * DisjointSet.java
 * 
 * Created by Vineet Jain on 6/5/16.
 *
 * Implements Union-Find data structure that supports union and find operations
 * along with methods for determining whether two elements are in the same
 * component and the total number of components. Uses weighted quick union by
 * size and path compression to optimize both the find and union queries.
 *
 * Each object in the data structure is represented using an integer from
 * 0...n-1 where n is the total number of objects stored. The union() and find()
 * expect that you pass in the integer representation of the objects so if you
 * want to use objects that are not integers, you will have to maintain a
 * mapping of object to integer as well.
 */
public class DisjointSet {

    private int[] items;
    private int[] size;
    private int count;

    /**
     * Initializes the data strcuture with n isolated components, numbered 0
     * through n-1. The initialization step takes O(n) time.
     */
    public void DisjointSet(int n){
        items = new int[n];
        size = new int[n];
        count = n;
        for(int i = 0; i < items.length; i++){
            items[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Checks if the two items are in the same component
     * @param x the integer representing one site
     * @param y the integer representing the other site
     * @return true if x and y are in the component, false otherwise
     */
    public boolean connected(int x, int y){
        return find(x) == find(y);
    }

    /**
     * Returns the identifier of the component representing site x. Implements
     * path compression
     * @param x the integer representing one site
     * @return the identifier of the component containing site x
     */
    public int find(int x){
        while (x != items[x]){
            items[x] = items[items[x]];
            x = items[x];
        }
        return x;
    }

    /**
     * Merges the component containing site x with the component containing
     * site x. Uses union by size to peform the union.
     * @param x the integer representing one site
     * @param y the integer representing the other site
     */
    public void union(int x, int y){
        int parentx = find(x);
        int parenty = find(y);
        if (x == y){
            return;
        } else{
            // make the smaller tree point to the larger one
            if (size[parentx] < size[parenty]){
                items[parentx] = parenty;
                size[parentx] += size[parenty];
            } else{
                items[parenty] = parentx;
                size[parentx] += size[parenty];
            }
            count--;
        }
    }

    /**
     * Returns the number of individual components in the Disjoint set
     * @return the number of individual components
     */
    public int count(){
        return count;
    }

    /**
     * toString method for a DisjointSet
     * @return a string representation of a DisjointSet
     */
    public String toString(){
        String str = new String();
        for(int i = 0; i < items.length; i++){
            str += items[i] + "\t";
        }
        return str;
    }
    }
}
