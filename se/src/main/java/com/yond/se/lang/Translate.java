package com.yond.se.lang;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 5/13/2025
 */
public interface Translate<From extends Language, To extends Language> {
    
    To translate(From from);
    
}
