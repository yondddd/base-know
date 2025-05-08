package com.yond.algorithm.struct.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: WangJieLong
 * @Date: 3/31/2025
 */
@Model("")
public class ArrayExample {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1, 1);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    
    private void arrayToList(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
    }
    
    class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
    
}
