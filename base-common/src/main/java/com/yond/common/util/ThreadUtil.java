package com.yond.common.util;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 2025-05-29
 */
public class ThreadUtil {
    
    public static String getThreadInfo() {
        Thread thread = Thread.currentThread();
        return String.format("[id=%d] [name=%s] [state=%s] [group=%s] [priority=%d] [daemon=%b] ",
                thread.threadId(),
                thread.getName(),
                thread.getState(),
                thread.getThreadGroup(),
                thread.getPriority(),
                thread.isDaemon());
    }
}
