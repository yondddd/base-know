package com.yond.se.lang;

import java.util.List;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 5/13/2025
 */
public class Person<T extends Language> {
    
    private List<T> languages;
    
    
    public List<T> getLanguages() {
        return languages;
    }
    
    public void setLanguages(List<T> languages) {
        this.languages = languages;
    }
    
    
}
