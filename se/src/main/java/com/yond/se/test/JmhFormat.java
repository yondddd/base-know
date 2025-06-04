package com.yond.se.test;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 6/3/2025
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class JmhFormat {
    
    @Benchmark
    public void stringFormat(Blackhole bh) {
        for (int i = 0; i < 100000; i++) {
            String format = String.format("%s,%s,%s,%s", "1111", "2222", "3333", "4444");
            bh.consume(format);
        }
    }
    
    @Benchmark
    public void messageFormat(Blackhole bh) {
        for (int i = 0; i < 100000; i++) {
            String s = MessageFormat.format("{0},{1},{2},{3}", "1111", "2222", "3333", "4444");
            bh.consume(s);
        }
    }
    
    @State(Scope.Thread)
    public static class MessageFormatState {
        MessageFormat messageFormat = new MessageFormat("{0},{1},{2},{3}");
        Object[] args = {"1111", "2222", "3333", "4444"};
    }
    
    @Benchmark
    public void messageFormatTemplate(MessageFormatState state, Blackhole bh) {
        for (int i = 0; i < 100000; i++) {
            String s = state.messageFormat.format(state.args);
            bh.consume(s);
        }
    }
    
    @Benchmark
    public void buildFormat(Blackhole bh) {
        for (int i = 0; i < 100000; i++) {
            String s = "1111" + "," +
                    "2222" + "," +
                    "3333" + "," +
                    "4444";
            bh.consume(s);
        }
    }
    
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhFormat.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}
