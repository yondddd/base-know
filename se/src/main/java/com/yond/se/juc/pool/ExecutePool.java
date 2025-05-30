package com.yond.se.juc.pool;

import com.yond.se.juc.pool.forkjoin.ForkJoinSumTask;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 2025-05-30
 */
public class ExecutePool {
    
    
    public static void main(String[] args) {
        
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        
        SumThread sumThread1 = new SumThread(1, 100);
        SumThread sumThread2 = new SumThread(101, 200);
        
        List<Future<Long>> futures = forkJoinPool.invokeAll(Arrays.asList(sumThread1, sumThread2));
        
        long totalSum = 0;
        for (Future<Long> future : futures) {
            try {
                totalSum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Total sum: " + totalSum);
        
        System.out.println("Total sum: " + forkJoinPool.invoke(new ForkJoinSumTask(1, 200)));
        
    }
    
    
    static class SumThread implements Callable<Long> {
        
        private final Integer start;
        private final Integer end;
        
        SumThread(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public Long call() throws Exception {
            Long sum = 0L;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
        
    }
}
