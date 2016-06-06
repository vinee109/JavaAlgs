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
}
