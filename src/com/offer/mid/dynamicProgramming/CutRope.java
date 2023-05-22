package com.offer.mid.dynamicProgramming;

/**
 * @author Basil
 * @description 剑指 Offer 14- I. 剪绳子
 * @note 3越多积越大；此题亦可以用数学方法做
 */
public class CutRope {
    public static void main(String[] args) {
        CutRope cutRope = new CutRope();
        System.out.println(cutRope.cuttingRopeOne(30));
        System.out.println(cutRope.cuttingRope(120));
    }

    public int cuttingRopeOne(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int three = n / 3;
        int remind = n % 3;
        int aws = 1;
        for (int i = 0; i < three; i++) {
            aws *= i < three - 1 ? 3 : (remind == 2 ? 3 * remind : (3 + remind));
            if (remind >= 1000000007) {
                remind = remind % 1000000007;
            }
        }
        return aws;
    }

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long res = 1;
        while (n > 4) {
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
