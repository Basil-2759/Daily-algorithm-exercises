package com.offer.mid.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/3/31 19:24
 *
 * 动态规划
 */
public class JunpGameII {
    public static void main(String[] args) {
        JunpGameII jumpGame = new JunpGameII();
        System.out.println(jumpGame.jump(new int[]{2,3,1,1,4}));
    }

    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
