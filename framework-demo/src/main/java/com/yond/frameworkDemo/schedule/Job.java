package com.yond.frameworkDemo.schedule;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @Description:
 * @Author: yond
 * @Date: 3/15/2025
 */
public class Job implements Comparable<Job> {
    
    private Runnable runnable;
    private long startTime;
    private long delay;
    
    public Runnable getRunnable() {
        return runnable;
    }
    
    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }
    
    public long getStartTime() {
        return startTime;
    }
    
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    
    public long getDelay() {
        return delay;
    }
    
    public void setDelay(long delay) {
        this.delay = delay;
    }
    
    
    @Override
    public int compareTo(Job o) {
        return Long.compare(this.startTime, o.startTime);
    }
    
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\yond\\Desktop\\New folder (3)\\New folder\\人脸识别照片库\\20250406");
        int index = 0;
        File[] files = file.listFiles();
        for (File file1 : files) {
            FileInputStream fileInputStream = new FileInputStream(file1);
            index++;
            Path path = Paths.get("C:\\Users\\yond\\Desktop\\New folder (3)\\New folder\\20250406\\" + index + ".jpg");
            Files.copy(fileInputStream, path, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
