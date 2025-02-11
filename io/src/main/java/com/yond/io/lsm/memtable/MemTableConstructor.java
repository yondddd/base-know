package com.yond.io.lsm.memtable;

@FunctionalInterface
public interface MemTableConstructor {
    MemTable create();
}
