package com.yond.io.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yond
 * @date 2/10/2025
 * @description
 */
public class IoBase {
    
    
    public void generateFile(Integer value, String unit, String filePath) throws IOException {
        long sizeInBytes = convertToBytes(value, unit); // 转换为字节数
        File file = new File(filePath);
        // 确保文件存在
        file.createNewFile();
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] buffer = new byte[102400000]; // 每次写入 1MB
            long writtenBytes = 0;
            // 循环写入数据直到达到指定文件大小
            while (writtenBytes < sizeInBytes) {
                // 如果剩余需要写入的字节数少于 buffer 的长度，则写入剩余字节数
                int bytesToWrite = (int) Math.min(buffer.length, sizeInBytes - writtenBytes);
                fos.write(buffer, 0, bytesToWrite); // 写入部分 buffer
                writtenBytes += bytesToWrite;
            }
            System.out.println("File generated: " + file.getAbsolutePath());
        }
    }

    
    private long convertToBytes(Integer value, String unit) {
        long sizeInBytes = 0;
        switch (unit.toLowerCase()) {
            case "mb":
                sizeInBytes = value * 1024L * 1024L;
                break;
            case "gb":
                sizeInBytes = value * 1024L * 1024L * 1024L;
                break;
            default:
                throw new IllegalArgumentException("Unsupported unit: " + unit);
        }
        return sizeInBytes;
    }
    
    public static void main(String[] args) {
        IoBase generator = new IoBase();
        try {
//            generator.generateFile(1, "GB", "E:\\file\\1g.txt");
//            generator.generateFile(5, "GB", "E:\\file\\5g.txt");
//            generator.generateFile(10, "GB", "E:\\file\\10g.txt");
            generator.generateFile(1, "GB", "D:\\file\\1g.txt");
//            generator.generateFile(50, "GB", "E:\\file\\50.txt");
//            generator.generateFile(100, "GB", "E:\\file\\100g.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
