package com.offer.mid.doublePointer;

/**
 * @author Basil
 * @create 2022/3/23 19:50
 * <p>
 * 双指针
 */
public class MostWaterContainer {
    public static void main(String[] args) {
        MostWaterContainer mostWaterContainer = new MostWaterContainer();
        System.out.println(mostWaterContainer.maxArea(new int[]{}));
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
