package com.yond.dataStruct;

import java.util.*;

/**
 * @author yond
 * @date 1/18/2025
 * @description
 */
public class Example {

    public static void main(String[] args) {
        List<Object> list = new LinkedList<>();
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Queue<Object> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        Stack<Object> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        System.out.println(stack.peek());

        Hashtable<String,Integer> hashTable = new Hashtable<>();

        heap
    }
}
