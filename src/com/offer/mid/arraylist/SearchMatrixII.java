package com.offer.mid.arraylist;

/**
 * @author Basil
 * @create 2022/8/16 9:43
 * @title 240. 搜索二维矩阵 II
 * @notes 分治法。左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。比较左下角元素和目标
 */
public class SearchMatrixII {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}}, 20));
        System.out.println(searchMatrix(new int[][]{
                {-1,3}}, 3));
    }

    /**
     * @param matrix
     * @param target
     *
     * 时间复杂度：O(m + n)。在搜索的过程中，如果我们没有找到 target，那么我们要么将 y 减少1，要么将 x 增加1。
     * 由于 (x, y) 的初始值分别为 (0, n-1)，因此 y 最多能被减少 n 次，x 最多能被增加 m 次，
     * 总搜索次数为 m + n。在这之后，x 和 y 就会超出矩阵的边界。
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        //从左下角开始
        int x = matrix.length - 1, y = 0;
        while (x >= 0 && y < matrix[0].length){
            if (target > matrix[x][y]){
                //若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，问题规模可以减小为在去掉第一列的子矩阵中寻找目标
                y++;
            }else if (target < matrix[x][y]){
                //若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
                x--;
            }else {
                //若左下角元素等于目标，则找到
                return true;
            }
        }

        return false;
    }
}
