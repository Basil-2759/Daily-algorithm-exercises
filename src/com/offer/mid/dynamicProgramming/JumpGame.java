package com.offer.mid.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/3/30 14:10
 *
 * 动态规划
 */
public class JumpGame {
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2,3,1,1,4}));
    }

    /**
     * 贪心算法
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int most = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= most) {
                most = Math.max(most, i + nums[i]);
                if (most >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
