package com.offer.easy.DBFS;

import java.util.Arrays;

/**
 * @author Basil
 * @create 2022/3/10 9:26
 * <p>
 * 深/广度优先搜索
 */
public class ImageRendering {
    public static void main(String[] args) {
        ImageRendering imageRendering = new ImageRendering();
        System.out.println(Arrays.deepToString(imageRendering.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
        System.out.println(Arrays.deepToString(imageRendering.floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int[][] flag = new int[image.length][image[0].length];
        for (int i = 0; i < flag.length; i++) {
            Arrays.fill(flag[0], 0);
        }
       return fill(image, image[sr][sc], sr, sc, newColor, flag);
    }

    public int[][] fill(int[][] image, int original, int sr, int sc, int newColor, int[][] flag) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && original == image[sr][sc] && flag[sr][sc] != 1) {
            image[sr][sc] = newColor;
            flag[sr][sc] = 1;
            fill(image, original, sr + 1, sc, newColor, flag);
            fill(image, original, sr - 1, sc, newColor, flag);
            fill(image, original, sr, sc + 1, newColor, flag);
            fill(image, original, sr, sc - 1, newColor, flag);
        }

        return image;
    }
}
