package com.yond.se.jvm;

public class Singleton {

  // 加载、链接(验证、准备、解析)、初始化
  private Singleton() {}
  private static class LazyHolder {
    static final Singleton INSTANCE = new Singleton();
    static {
      System.out.println("LazyHolder.<clinit>");
    }
  }
  public static Object getInstance(boolean flag) {
    // 新建数组不会导致初始化
    if (flag) return new LazyHolder[2];
    return LazyHolder.INSTANCE;
  }
  public static void main(String[] args) {
    getInstance(true);
    System.out.println("----");
    getInstance(false);
  }

}