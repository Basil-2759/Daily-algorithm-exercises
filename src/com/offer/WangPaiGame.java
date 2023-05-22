package com.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/12/20 17:04
 * @description 王牌游戏-笔试
 */
public class WangPaiGame {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3));
    }

    /**
     * 在一个已排序（由小到大）数组 int x[M]中，编写一个函数，
     * 采用二分法查找某个数n在数组中的索引,返回这个索引值。(不允许使用任何库函数)
     */
    public static int binarySearch(int[] x, int n) {
        int left = 0, right = x.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (x[middle] > n) {
                right = middle - 1;
            } else if (x[middle] < n) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        // 未找到目标值
        return -1;
    }

    /**
     * 首先定义一个二叉树(假设树的结点上只存放一个整数)
     * (1) 写一个函数, 返回二叉树的深度（例如右侧的树，返回4）。
     * (2) 写一个函数，将二叉树进行层次遍历，输出各结点的值
     * （例如右侧的树，输出 1 2 3 4 5 6 7 8 9 10），可使用标准库的类及函数。
     *
     * 答题详见：com.offer.TreeNode
     */
}
