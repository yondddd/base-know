package com.yond.io.base;

import java.io.FileInputStream;
import java.util.function.Consumer;

/**
 * @author yond
 * @date 2/10/2025
 * @description
 */
public interface ReadAction<T> {
    
    void read(FileInputStream stream, Consumer<T> consumer);
    
}
