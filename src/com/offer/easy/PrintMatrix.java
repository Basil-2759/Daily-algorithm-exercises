package com.offer.easy;

import java.util.ArrayList;

public class PrintMatrix {
    public static void main(String[] args) {
        PrintMatrix printMatrix=new PrintMatrix();
        int lang=1;
        int wid=10;
        int[][] mat=new int[wid][lang];
        int k=1;

        for (int i = 0; i < wid; i++) {
            for (int i1 = 0; i1 < lang; i1++) {
                mat[i][i1]=k;
                k++;
            }
        }

        int[] list=printMatrix.spiralOrder(mat);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public int[] spiralOrder(int[][] matrix) {
        ArrayList<Integer> aws=new ArrayList<Integer>();
        int minus=0;
        int num=0;

        if (matrix.length==0){
            int[] zero=new int[0];
            return zero;
        }

        while (minus<matrix.length-minus){
            for (int i = minus; i < matrix[0].length-minus; i++) {//从左到右
                aws.add(matrix[minus][i]);
                num++;
            }
            if (num==matrix.length*matrix[0].length){
                break;
            }
            for (int i = minus+1; i < matrix.length-minus; i++) {//从上到下
                aws.add(matrix[i][matrix[0].length-minus-1]);
                num++;
            }
            for (int i = matrix[0].length-minus-2; i >= minus; i--) {//从右到左
                aws.add(matrix[matrix.length-minus-1][i]);
                num++;
            }
            if (num==matrix.length*matrix[0].length){
                break;
            }
            for (int i = matrix.length-minus-2; i >= minus+1; i--) {//从下到上
                aws.add(matrix[i][minus]);
                num++;
            }
            minus++;
        }

        int[] answer=new int[matrix.length*matrix[0].length];
        for (int i = 0; i < answer.length; i++) {
            answer[i]=aws.get(i);
        }
        return answer;
    }
}
