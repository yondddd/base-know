package com.yond.algorithm.hot100.doublePointer;

/**
 * @Date 4/28/2024
 * @Author yond
 * @Description container with most water
 */
public class MaxArea {


    /**
     * [1,8,6,2,5,4,8,3,7]
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int minHeight = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int min = Math.min(leftHeight, rightHeight);
            if (min > minHeight) {
                maxArea = Math.max(maxArea, min * (right - left));
                minHeight = min;
            }
            if (rightHeight > leftHeight) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
