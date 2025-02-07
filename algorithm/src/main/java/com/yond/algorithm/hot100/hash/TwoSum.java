package com.yond.algorithm.hot100.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yond
 * @date 4/17/2024
 * @description
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        for (int a = 0; a < nums.length; a++) {
            for (int b = 0; b < nums.length; b++) {
                if (nums[a] + nums[b] == target && a != b) {
                    out[0] = a;
                    out[1] = b;
                    break;
                }

            }
        }
        return out;
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] out = new int[2];
        for (int a = 0; a < nums.length; a++) {
            for (int b = nums.length - 1; b > a; b--) {
                if (nums[a] + nums[b] == target) {
                    out[0] = a;
                    out[1] = b;
                    return out;
                }
            }
        }
        return out;
    }


    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            Integer indexExist = map.get(target - val);
            if (indexExist != null) {
                return new int[]{i, indexExist};
            }
            map.put(val, i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

    }
}
