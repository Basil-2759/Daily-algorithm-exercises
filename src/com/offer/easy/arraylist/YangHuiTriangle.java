package com.offer.easy.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/8/13 10:24
 * @title 119. 杨辉三角 II
 * @notes 总体来说是动态规划的思想，若将时间复杂度将为O(n)，可利用排列组合公式去做（详见此题题解）
 */
public class YangHuiTriangle {
    public static void main(String[] args) {
        System.out.println(getRow(3));
        System.out.println(getRow(4));
    }

    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex == 0){
            return ans;
        }
        ans.add(1);
        if (rowIndex == 1){
            return ans;
        }
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j > 0; j--){
                ans.set(j, ans.get(j - 1) + ans.get(j));
            }
            ans.add(1);
        }

        return ans;
    }
}
