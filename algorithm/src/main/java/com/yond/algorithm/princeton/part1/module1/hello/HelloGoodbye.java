package com.yond.algorithm.princeton.part1.module1.hello;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HelloGoodbye {

    public static void main(String[] args) {
        if (args == null) {
            System.out.println("arg is null");
            return;
        }
        String delimiter = " and ";
        System.out.println("Hello " + String.join(delimiter, args) + ".");
        List<String> list = Arrays.asList(args);
        Collections.reverse(list);
        System.out.println("Goodbye " + String.join(delimiter, list) + ".");
    }
}
