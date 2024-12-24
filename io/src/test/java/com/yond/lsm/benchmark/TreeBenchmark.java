package com.yond.lsm.benchmark;

import com.yond.lsm.Config;
import com.yond.lsm.Tree;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static com.yond.lsm.TreeTestHelper.cleanFolder;

@State(Scope.Benchmark)
public class TreeBenchmark {
    
    private Tree tree;
    static final String keyPrefix = "preFix";
    
    @Setup
    public void setup() {
        tree = new Tree(Config.newConfig("/tmp/yumi"));
    }
    
    @TearDown
    public void tearDown() {
        tree.close();
    }
    
    @Benchmark
    @BenchmarkMode({Mode.Throughput})
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Threads(8)
    public void putAndGet() {
        String key = keyPrefix + ThreadLocalRandom.current().nextInt(10000000);
        tree.put(key.getBytes(), key.getBytes());
        key = keyPrefix + ThreadLocalRandom.current().nextInt(10000000);
        tree.get(key.getBytes());
    }
    
    public static void main(String[] args) throws RunnerException {
        String workDir = "/tmp/yumi";
        File file = new File(workDir);
        cleanFolder(file);
        file.delete();
        
        
        Options opt = new OptionsBuilder()
                .include(TreeBenchmark.class.getSimpleName())
                .forks(1)
                .measurementIterations(60)
                .build();
        new Runner(opt).run();
    }
}
