package com.yond.hot100.doublePointer;


import java.util.Arrays;

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

    private int[] solution4(int[] nums) {
        int fast = 0;
        int slow = 0;
        for (int i = fast; i < nums.length; i++) {
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



    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZero moveZero = new MoveZero();
        int[] solution = moveZero.solution(nums);
        for (int i : solution) {
            System.out.println(i);
        }
        int[] solution2 = moveZero.solution4(nums);
        for (int i : solution2) {
            System.out.println(i);
        }
    }
    
}
