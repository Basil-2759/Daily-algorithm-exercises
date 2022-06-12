package com.offer.easy;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class From1ToN {
    public static void main(String[] args) {
        From1ToN from1ToN=new From1ToN();
        int[] k=from1ToN.printNumbers(2);
        for (int i = 0; i < k.length; i++) {
            System.out.println(k[i]);
        }
    }

    public int[] printNumbers(int n) {
        int m=0,j=1;//m用来计算最大的n位数，j辅助计算

        for (int i = 0; i < n;i++) {
            m=m+9*j;
            j*=10;
        }

        int[] aws=new int[m];
        for (int i = 0; i < m; i++) {
            aws[i]=i+1;
        }
        return aws;
    }
}
