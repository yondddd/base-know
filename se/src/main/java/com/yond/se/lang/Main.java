package com.yond.se.lang;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 5/8/2025
 */
public class Main {
    
    public static void main(String[] args) {
        byte a = 127;
        byte b = 127;
//        b = a + b; // error : cannot convert from int to byte
        b += a; // ok
        System.out.println(b);
    }
}
