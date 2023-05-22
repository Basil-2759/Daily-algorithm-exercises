package com.huawei.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author Basil
 * @create 2022/9/3 16:34
 * @title HJ6 质数因子
 * @notes 直到√num为止，如果此时数字还没有除数，则可判定其本身是一个质数
 */
public class PrimeFactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long k = (long) Math.sqrt(num);
        for (long i = 2; i <= k; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println(num == 1 ? "" : num + " ");
    }
}
