package com.yond.se.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @Date 4/27/2024
 * @Author yond
 * @Description io api
 */
public class Api {



    /**
     * 1. 为什么要用try包起来
     */
    private static byte[] readFile(String filePath) throws IOException {
        File file = new File(filePath);
        ByteBuffer result = ByteBuffer.allocate((int) file.length());
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            FileChannel channel = fileInputStream.getChannel();
            while (channel.read(result) != -1) {
                result.compact();
            }
        }
        return result.array();
    }


    private static void writeByte(String filePath, byte[] bytes) {

    }


    public static void main(String[] args) throws IOException {
        String path = "F:\\back\\resources\\io\\New Text Document.txt";
        byte[] bytes = Api.readFile(path);
        String s = new String(bytes, Charset.defaultCharset());
        System.out.println(s);
    }

}
