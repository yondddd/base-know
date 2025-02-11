package com.yond.io.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * @author yond
 * @date 2/10/2025
 * @description
 */
public class ReadTxtAction implements ReadAction<String>{

    @Override
    public void read(FileInputStream stream, Consumer<String> consumer) {
        byte[] bytes = null;
        try {
            bytes = stream.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        consumer.accept(new String(bytes));
    }
    
}
