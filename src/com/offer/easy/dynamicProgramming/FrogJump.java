package com.offer.easy.dynamicProgramming;

/**
 * @author Basil
 * @description 剑指 Offer 10- II. 青蛙跳台阶问题
 * @note 青蛙跳台阶：本质上就是斐波那契数列
 */
public class FrogJump {
    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        System.out.println(frogJump.numWays(44));
    }

    public int numWays(int n) {
        int[] list = new int[101];
        list[0] = 1;
        list[1] = 1;
        list[2] = 2;
        for (int i = 3; i <= n; i++) {
            list[i] = (list[i - 1] + list[i - 2]) % 1000000007;
        }
        return list[n];
    }
}