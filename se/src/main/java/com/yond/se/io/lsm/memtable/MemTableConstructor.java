package com.yond.se.io.lsm.memtable;

@FunctionalInterface
public interface MemTableConstructor {
    MemTable create();
}
