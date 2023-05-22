package com.offer.mid.DBFS;

/**
 * @author Basil
 * @description 剑指 Offer 12. 矩阵中的路径
 * @note dfs + 回溯
 */
public class RoadOfMatrix {
    public static void main(String[] args) {
        RoadOfMatrix roadOfMatrix = new RoadOfMatrix();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        char[][] a = {{'a'}};
        char[][] abcd = {
                {'a', 'b'},
                {'c', 'd'}};
        char[][] caa = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};
        System.out.println(roadOfMatrix.exist(caa, "AAB"));
//        System.out.println(roadOfMatrix.existttt(abcd,"acdb"));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        // 用来标记该位置是否已经走过
        int[][] flag = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, flag, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, int[][] flag, String word, int x, int y, int index) {
        if (index == word.length()) {
            // 正好找到
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            // 超过数组了，没找到
            return false;
        }
        if (board[x][y] == word.charAt(index) && flag[x][y] != 1) {
            flag[x][y] = 1;
            index++;
            boolean a = search(board, flag, word, x + 1, y, index);
            boolean b = search(board, flag, word, x, y + 1, index);
            boolean c = search(board, flag, word, x, y - 1, index);
            boolean d = search(board, flag, word, x - 1, y, index);
            if (a || b || c || d) {
                return true;
            }
        } else {
            return false;
        }
        // 在 dfs 的过程当中，如果某条路已经不通了，那么需要回溯，也就是将 flag[x][y] 位置置为 0；
        flag[x][y] = 0;
        return false;
    }


    public boolean existttt(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从 (0, 0) 点开始进行 dfs 操作，不断地去找，
                // 如果以 (0, 0) 点没有对应的路径的话，那么就从 (0, 1) 点开始去找
                if (dfs(board, chars, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, boolean[][] visited, int i, int j, int start) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || chars[start] != board[i][j] || visited[i][j]) {
            return false;
        }
        if (start == chars.length - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean ans;
        ans = dfs(board, chars, visited, i + 1, j, start + 1)
                || dfs(board, chars, visited, i - 1, j, start + 1)
                || dfs(board, chars, visited, i, j + 1, start + 1)
                || dfs(board, chars, visited, i, j - 1, start + 1);
        visited[i][j] = false;
        return ans;
    }
}
