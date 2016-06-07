package applications.percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
/**
 * applications.percolation.PercolationStats.java
 *
 * Created by Vineet Jain on 6/6/16.
 */
public class PercolationStats {

    private double [] experiments;
    private int T;

    /**
     * Perform T experiments on an N-by-N grid
     * @param N the size dimension of the grid
     * @param T the number of experiments to be performed
     */
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        experiments = new double[T];
        this.T = T;

        for (int x = 0; x < T; x++) {
            Percolation perc = new Percolation(N);
            int numOpen = 0;
            while (!perc.percolates()) {
                int i = StdRandom.uniform(1, N+1);
                int j = StdRandom.uniform(1, N+1);
                if (!perc.isOpen(i, j)) {
                    perc.open(i, j);
                    numOpen++;
                }
            }
            experiments[x] = (double) numOpen / (N*N);
        }
    }

    /**
     * Returns the sample mean of the percolation threshold
     * @return the sample mean of the percolation threshold
     */
    public double mean() {
        return StdStats.mean(experiments);
    }

    /**
     * Returns the sample stddev of the percolation threshold
     * @return the sample stddev of the percolation threshold
     */
    public double stddev() {
        return StdStats.stddev(experiments);
    }

    /**
     * Low endpoint of 95% confidence interval
     * @return Low endpoint of 95% confidence interval
     */
    public double confidenceLo() {
        return mean() - (1.96*stddev()) / Math.sqrt(T);
    }

    /**
     * High endpoint of 95% confidence interval
     * @return High endpoint of 95% confidence interval
     */
    public double confidenceHi() {
        return mean() + (1.96*stddev()) / Math.sqrt(T);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Missing arguments");
            return;
        }
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(N, T);
        StdOut.println("mean                    = " + stats.mean());
        StdOut.println("stddev                  = " + stats.stddev());
        StdOut.println("95% confidence interval = " +
                stats.confidenceLo() + ", " + stats.confidenceHi());
    }
}
