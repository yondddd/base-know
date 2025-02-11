package com.yond.io.base;

import java.io.FileInputStream;

/**
 * @author yond
 * @date 2/10/2025
 * @description
 */
public class IoBase {
    
    public void read(ReadAction<?> readAction){
        readAction.read()
    }
    
    
}
