package com.offer.easy.dynamicProgramming;

/**
 * @author Basil
 * @create 2022/3/15 11:33
 *
 * 动态规划
 */
public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(3));
        System.out.println(climbStairs.climbStairs(4));
        System.out.println(climbStairs.climbStairs(5));
    }

    public int climbStairs(int n) {
        //f(x)=f(x−1)+f(x−2)
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
