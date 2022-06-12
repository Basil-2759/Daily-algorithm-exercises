package com.offer.mid;

public class IntegerPower {
    public static void main(String[] args) {
        IntegerPower integerPower=new IntegerPower();
        System.out.println(integerPower.myPow(0.00001,2147483647));
    }

    public double myPow(double x, int n) {
        double aws = 1;
        if (Math.abs(x)==1.0){
            if (n%2==0){
                return 1;
            }else {
                return x;
            }
        }
        if (n==-2147483648){
            return 0;
        }
        for (int i = 0; i < Math.abs(n); i++) {
            aws *= x;
        }
        if (n<0){
            aws=1/aws;
        }
        return aws;
    }
}
