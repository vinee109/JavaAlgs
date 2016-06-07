import edu.princeton.cs.algs4.WeightedQuickUnionUF;
/**
 * applications.percolation.Percolation.java
 *
 * Created by Vineet Jain on 6/6/16.
 *
 * The Percolation class models a percolation system using an N by N grid of
 * sites. Each site is either open or blocked. The row and column indices, i
 * and j are integers between 1 and N, where (1, 1) is the upper-left site.
 */
public class Percolation {
    // Virtual index representing top of the grid
    private static final int TOP = 0;
    // Virtual index representing bottom of the grid
    private static final int BOTTOM = 1;

    private boolean [][] grid;
    // Union Find data structure to represent each of the sites in the N by N
    // grid
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF flow;
    private int N;
    /**
     * Create an N-by-N grid with all sites blocked.
     * @param N the size parameter
     * @throws IllegalArgumentException if N <= 0
     *
     */
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        grid = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N*N+2);
        flow = new WeightedQuickUnionUF(N*N+2);
        this.N = N;

        // Connect virtual top to the top row and virtual bottom to the bottom
        // row
        for (int i = 0; i < N; i++) {
            uf.union(TOP, 2+i);
            flow.union(TOP, 2+i);
            uf.union(BOTTOM, 2+i+(N-1)*N);
        }
    }

    /**
     * Returns the integer representation of a site in the grid
     * @param i the row coordinate of the site
     * @param j the column coordinate of the site
     * @return the integer representation of the site to be used in the union
     * find data structure
     */
    private int unionFindIndex(int i, int j) {
        return (i-1) * N + (j-1) + 2;
    }

    /**
     * Returns whether (i, j) is within bounds of the N by N grid
     * @param  i the row index
     * @param  j the column index
     * @return  true if (i, j) is within bounds of the grid, false otherwise
     */
    private boolean inBounds(int i, int j) {
        return !(i < 1 || j < 1 || j > N || i > N);
    }

    /**
     * Opens the site (i, j) on the N-by-N grid
     * @param i the row coordinate of the site location
     * @param j the column coordinate of the site location
     * @throws IndexOutOfBoundsException if i and j are not between 1 and N
     */
    public void open(int i, int j) {
        if (!inBounds(i, j)) {
            throw new IndexOutOfBoundsException("i and j are not within " +
                    "bounds of the grid");
        }
        if (!grid[i-1][j-1]) {
            grid[i-1][j-1] = true;
            // check if neighboring sites are open, if so union them together
            // to represent that they are connected
            if (inBounds(i-1, j) && isOpen(i-1, j)) {
                uf.union(unionFindIndex(i, j), unionFindIndex(i-1, j));
                flow.union(unionFindIndex(i, j), unionFindIndex(i-1, j));
            }
            if (inBounds(i+1, j) && isOpen(i+1, j)) {
                uf.union(unionFindIndex(i, j), unionFindIndex(i+1, j));
                flow.union(unionFindIndex(i, j), unionFindIndex(i+1, j));
            }
            if (inBounds(i, j-1) && isOpen(i, j-1)) {
                uf.union(unionFindIndex(i, j), unionFindIndex(i, j-1));
                flow.union(unionFindIndex(i, j), unionFindIndex(i, j-1));
            }
            if (inBounds(i, j+1) && isOpen(i, j+1)) {
                uf.union(unionFindIndex(i, j), unionFindIndex(i, j+1));
                flow.union(unionFindIndex(i, j), unionFindIndex(i, j+1));
            }
        }
    }

    /**
     * Returns whether site (i, j) is open or not
     * @param i the row coordinate of the site location
     * @param j the column coordinate of the site location
     * @return true if site (i, j) is open, false otherwise
     * @throws IndexOutOfBoundsException if i and j are not within bounds of
     * the grid
     */
    public boolean isOpen(int i, int j) {
        if (!inBounds(i, j)) {
            throw new IndexOutOfBoundsException("i and j are not within " +
                    "bounds of the grid");
        }
        return grid[i-1][j-1];
    }

    /**
     * Returns whether site (i, j) is full or not
     * @param i the row coordinate of the site location
     * @param j the column coordinate of the site location
     * @return true if site (i, j) is full, false otherwise
     * @throws IndexOutOfBoundsException if i and j are note within bounds of
     * the grid
     */
    public boolean isFull(int i, int j) {
        if (!inBounds(i, j)) {
            throw new IndexOutOfBoundsException("i and j are not within " +
                    "bounds of the grid");
        }
        return isOpen(i, j) && flow.connected(TOP, unionFindIndex(i, j));
    }

    /**
     * Returns whether the system percolates
     * @return true if the system percolates, false otherwise
     */
    public boolean percolates() {
        if (N == 1) {
            return uf.connected(TOP, BOTTOM) && isOpen(1, 1);
        }
        return uf.connected(TOP, BOTTOM);
    }
}
