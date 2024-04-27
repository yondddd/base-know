package com.yond;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Date 4/27/2024
 * @Author yond
 * @Description io api
 */
public class Api {



    /**
     * 1. 为什么要用try包起来
     */
    private static void readFile(String filePath) throws IOException {
        File file = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            FileChannel channel = fileInputStream.getChannel();
            fileInputStream.read();
            channel.read();
        }

    }


    public static void main(String[] args) throws IOException {
        String path = "F:\\back\\resources\\io\\New Text Document.txt";
        Api.readFile(path);
    }

}
