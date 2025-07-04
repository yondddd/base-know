package com.yond.algorithm.struct.array;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 5/26/2025
 */
public class MyArrayList<E> implements List<E> {
    
    private E[] data;
    
    @Override
    public int size() {
        return data.length;
    }
    
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    @Override
    public boolean contains(Object o) {
        Thread thread = Thread.currentThread();
        thread.getThreadGroup();
        thread.threadId();
        
        for (E datum : data) {
            if (datum.equals(o)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Iterator<E> iterator() {
        return null;
    }
    
    @Override
    public Object[] toArray() {
        return data;
    }
    
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }
    
    @Override
    public boolean add(E e) {
        return false;
    }
    
    @Override
    public boolean remove(Object o) {
        return false;
    }
    
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }
    
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }
    
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public void clear() {
    
    }
    
    @Override
    public E get(int index) {
        return null;
    }
    
    @Override
    public E set(int index, E element) {
        return null;
    }
    
    @Override
    public void add(int index, E element) {
    
    }
    
    @Override
    public E remove(int index) {
        return null;
    }
    
    @Override
    public int indexOf(Object o) {
        return 0;
    }
    
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
    
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }
    
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
    
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
