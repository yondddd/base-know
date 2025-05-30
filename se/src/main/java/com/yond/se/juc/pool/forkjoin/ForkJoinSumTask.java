package com.yond.se.juc.pool.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumTask extends RecursiveTask<Long> {
    
    private final int start;
    private final int end;
    private static final long THRESHOLD = 10_000; // 拆分阈值
    
    public ForkJoinSumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        
        // 拆分任务
        ForkJoinSumTask leftTask = new ForkJoinSumTask(start, start + length / 2);
        leftTask.fork(); // 异步执行
        
        ForkJoinSumTask rightTask = new ForkJoinSumTask(start + length / 2, end);
        Long rightResult = rightTask.compute(); // 同步执行
        Long leftResult = leftTask.join(); // 获取异步结果
        
        return leftResult + rightResult;
    }
    
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}