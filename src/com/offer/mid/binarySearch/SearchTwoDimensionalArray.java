package com.offer.mid.binarySearch;

/**
 * @author Basil
 * @create 2022/3/19 10:51
 * <p>
 * 二分查找
 */
public class SearchTwoDimensionalArray {
    public static void main(String[] args) {
        SearchTwoDimensionalArray searchTwoDimensionalArray = new SearchTwoDimensionalArray();
        System.out.println(searchTwoDimensionalArray.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}}, 13));
        System.out.println(searchTwoDimensionalArray.searchMatrix(new int[][]{{1}}, 0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = -1, right = matrix.length - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) / 2);
            if (target < matrix[mid][0]) {
                right = mid - 1;
            } else if (target > matrix[mid][0]) {
                left = mid;
            } else {
                return true;
            }
        }
        int t = left;
        if (t < 0) {
            return false;
        }
        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (target < matrix[t][mid]) {
                right = mid - 1;
            } else if (target > matrix[t][mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
