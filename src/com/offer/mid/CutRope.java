package com.offer.mid;

public class CutRope {
    public static void main(String[] args) {
        CutRope cutRope=new CutRope();
        System.out.println(cutRope.cuttingRopeOne(120));
        System.out.println(cutRope.cuttingRope(120));
    }

    public int cuttingRopeOne(int n) {
        if (n<=3){
            return n-1;
        }
        int three=n/3;
        int remind=n%3;
        int aws=1;
        for (int i = 0; i < three; i++) {
            aws *= i<three-1 ? 3 : (remind == 2 ? 3*remind : (3+remind));
            aws= aws % 1000000007;
            if (remind >= 1000000007) {
                remind = remind%1000000007;
            }
        }
        System.out.println(aws);
        return (aws%1000000007);
    }

    public int cuttingRope(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        long res = 1;
        while(n > 4){
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        System.out.println(res*n);
        return (int)(res * n % 1000000007);
    }
}
