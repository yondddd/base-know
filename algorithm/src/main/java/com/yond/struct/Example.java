package com.yond.struct;

import com.yond.common.util.LogUtil;

import java.util.*;

/**
 * @author yond
 * @date 1/18/2025
 * @description
 */
public class Example {

    public static void main(String[] args) {
        List<Object> list = new LinkedList<>();
        list.add(1);
        for (Object o : list) {
            LogUtil.console(o);
        }

        Queue<Object> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        LogUtil.console(queue.poll());
        LogUtil.console(queue.peek());
        
        Deque<Object> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        LogUtil.console(deque.pop());
    }
    
}
