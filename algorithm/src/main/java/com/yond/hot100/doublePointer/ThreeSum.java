package com.yond.hot100.doublePointer;

import java.util.*;

/**
 * @Date 4/28/2024
 * @Author yond
 * @Description threeSum
 */
public class ThreeSum {

    /**
     * Example 1:
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (left > i + 1) {
                    if (nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                }
                if (right < nums.length - 1) {
                    if (nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                }
                int size = nums[left] + nums[right];
                int sum = size + target;
                if (sum < 0) {
                    left++;
                } else {
                    if (sum == 0) {
                        // add
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[left]);
                        list.add(nums[right]);
                        list.add(target);
                        result.add(list);
                    }
                    right--;
                }
            }
        }
        return result;
    }


    public List<List<Integer>> nSum(int[] nums) {
        // 双指针+递归
        Arrays.sort(nums);
        return nSUmTarget(nums, 3, 0, 0);
    }


    private List<List<Integer>> nSUmTarget(int[] nums, int n, int index, int target) {
        int arrayLength = nums.length;
        if (arrayLength < 2 || n < 2) {
            return Collections.emptyList();
        }
        if (n == 2) {
            int left = index;
            int right = arrayLength - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {

                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        // 递归
    }



}
