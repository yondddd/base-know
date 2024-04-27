package com.yond.hot100.doublePointer;

import java.io.File;

/**
 * @author yond
 * @date 4/21/2024
 * @description
 */
public class MoveZero {

    private int[] solution(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
        return nums;
    }
    
    
    private int[] solution2(int[] nums) {
        
        new File()
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                nums[i] = null;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZero moveZero = new MoveZero();
        int[] solution = moveZero.solution(nums);
        for (int i : solution) {
            System.out.println(i);
        }
    }
    
}
