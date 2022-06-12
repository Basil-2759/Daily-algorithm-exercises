package com.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Basil
 * @create 2022/4/18 16:45
 */
public class AiShuFirst {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _matrix_rows = 0;
        int _matrix_cols = 0;
        _matrix_rows = Integer.parseInt(in.nextLine().trim());
        _matrix_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _matrix = new int[_matrix_rows][_matrix_cols];
        for(int _matrix_i=0; _matrix_i<_matrix_rows; _matrix_i++) {
            for(int _matrix_j=0; _matrix_j<_matrix_cols; _matrix_j++) {
                _matrix[_matrix_i][_matrix_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = new AiShuFirst().spiralOrder(_matrix);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int num = n * m;
        List<Integer> ans = new ArrayList<>();
        if (num == 0){
            return new int[]{};
        }

        int step = 1;
        int flag = 0;
        while (ans.size() < num){
            for (int i = flag; i < m; i++) {
                ans.add(matrix[flag][i]);
            }
            for (int i = step; i < n; i++){
                ans.add(matrix[i][m - step]);
            }
            for (int i = m - 1 - step; i > flag ; i++) {
                ans.add(matrix[n - step][i]);
            }
            for (int i = n - step; i > flag ; i--) {
                ans.add(matrix[i][flag]);
            }
            step++;
            flag++;
        }

        int circle = 0;
        while (ans.size() < num){
            for (int i = circle; i < m; i++) {
                ans.add(matrix[flag][i]);
            }
            for (int i = step; i < n; i++){
                ans.add(matrix[i][m - step]);
            }
            for (int i = m - 1 - step; i > flag ; i++) {
                ans.add(matrix[n - step][i]);
            }
            for (int i = n - step; i > flag ; i--) {
                ans.add(matrix[i][flag]);
            }
        }

        int[] answer = new int[num];
        for (int i = 0; i < num; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
