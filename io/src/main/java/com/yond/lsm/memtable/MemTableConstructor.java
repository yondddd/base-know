package com.yond.lsm.memtable;

@FunctionalInterface
public interface MemTableConstructor {
    MemTable create();
}
