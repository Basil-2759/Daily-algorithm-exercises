package com.offer.mid.arraylist;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/8/13 11:06
 * @title 48. 旋转图像
 * @notes 先转置，再镜像
 */
public class SpinImage {
    public static void main(String[] args) {
        int [][] image = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(image);
        System.out.println(Arrays.deepToString(image));
    }

    public static void rotate(int[][] matrix) {
        //转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int flag =  matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = flag;
            }
        }
        //镜像
        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix.length - 1;
            while (right > left){
                int flag = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = flag;
                left++;
                right--;
            }
        }
    }
}
