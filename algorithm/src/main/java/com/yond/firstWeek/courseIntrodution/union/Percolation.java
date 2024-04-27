//package org.tom.firstWeek.courseIntrodution.union;
//
//import edu.princeton.cs.algs4.WeightedQuickUnionUF;
//
//public class Percolation {
//
//    private final WeightedQuickUnionUF weightedQuickUnionUF;
//
//    // creates n-by-n grid, with all sites initially blocked
//    public Percolation(int n) {
//        // consider 1 is blocked
//        weightedQuickUnionUF = new WeightedQuickUnionUF(n * n - 1);
//    }
//
//    // opens the site (row, col) if it is not open already
//    public void open(int row, int col) {
//
//    }
//
//    // is the site (row, col) open?
//    public boolean isOpen(int row, int col) {
//        int index = this.index(row, col);
//        return index == weightedQuickUnionUF.find(index);
//    }
//
//    // is the site (row, col) full?pp
//    public boolean isFull(int row, int col) {
//        // is connected around?
//    }
//
//    // returns the number of open sites
//    public int numberOfOpenSites() {
//
//    }
//
//    // does the system percolate?
//    public boolean percolates() {
//
//    }
//
//    private int index(int row, int col) {
//        return 0;
//    }
//    // test client (optional)
//    public static void main(String[] args) {
//
//    }
//
//}