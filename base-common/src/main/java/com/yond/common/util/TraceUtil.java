package com.yond.common.util;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/23/2025
 */
public class TraceUtil {
    
    private static final Map<String, Trace> MAP = new HashMap<>();
    
    public static Trace getTrace(String key) {
        Trace trace = MAP.get(key);
        if (trace == null) {
            trace = new Trace(key);
            MAP.put(key, trace);
        }
        return trace;
    }
    
    public static class Trace {
        
        private final String key;
        
        private final List<String> msgs = new ArrayList<>();
        
        private final AtomicInteger step = new AtomicInteger(0);
        
        private final Set<String> distinct = new HashSet<>();
        
        Trace(String key) {
            this.key = key;
        }
        
        public void trace(String format, Object... args) {
            trace0(true, false, format, args);
        }
        
        public void traceIf(boolean condition, String format, Object... args) {
            trace0(condition, false, format, args);
        }
        
        public void traceOnceIf(boolean condition, String format, Object... args) {
            trace0(condition, true, format, args);
        }
        
        public void trace0(boolean condition, boolean once, String format, Object... args) {
            String threadName = Thread.currentThread().getName();
            String msg = String.format(format, args);
            boolean log = true;
            if (once) {
                log = !distinct.contains(threadName + msg);
            }
            if (condition && log) {
                msgs.add(String.format("step%s-%s-%s", step.getAndIncrement(), threadName, msg));
                distinct.add(threadName + msg);
            }
        }
        
        public void console() {
            msgs.forEach(System.out::println);
            MAP.remove(key);
        }
    }
    
}
