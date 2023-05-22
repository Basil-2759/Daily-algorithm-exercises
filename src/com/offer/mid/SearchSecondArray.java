package com.offer.mid;

/**
 * @author Basil
 * @description 剑指 Offer 04. 二维数组中的查找
 */
public class SearchSecondArray {
    public static void main(String[] args) {
        SearchSecondArray searchSecondArray = new SearchSecondArray();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] test = {{1, 4}, {2, 5}};
        System.out.println(searchSecondArray.findNumberIn2DArray(test, 5));


    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * @description 失败的自创方法
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0]) {
            return false;
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                if (target == matrix[i][0]) {
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (target == matrix[0][i]) {
                return true;
            } else if (target < matrix[0][i]) {
                for (int j = 1; j < matrix.length; j++) {
                    if (target == matrix[j][i - 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
