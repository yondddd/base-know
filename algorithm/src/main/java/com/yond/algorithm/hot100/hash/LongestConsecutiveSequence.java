package com.yond.algorithm.hot100.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yond
 * @date 4/17/2024
 * @description
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int length = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int temp = 0;
            while (set.contains(num + 1)) {
                num++;
                temp++;
            }
            length = Math.max(temp, length);
        }
        return length;
    }
}
