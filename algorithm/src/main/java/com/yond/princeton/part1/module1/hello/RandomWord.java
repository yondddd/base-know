package com.yond.princeton.part1.module1.hello;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) {
        int index = 0;
        String out = "";
        while (!StdIn.isEmpty()) {
            String newString = StdIn.readString();
            boolean replace = StdRandom.bernoulli((double) 1 / ++index);
            if (replace) {
                out = newString;
            }
        }
        StdOut.print(out);
    }


}