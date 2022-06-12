package com.offer.mid.DBFS;

/**
 * @author Basil
 * @create 2022/3/28 16:23
 * <p>
 * 深/广度优先遍历
 */
public class SurroundingArea {
    public static void main(String[] args) {
        SurroundingArea surroundingArea = new SurroundingArea();
        surroundingArea.solve(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        });
    }

    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, m - 1, m, n);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i, m, n);
            dfs(board, n - 1, i, m, n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y, int m, int n) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y, m, n);
        dfs(board, x - 1, y, m, n);
        dfs(board, x, y + 1, m, n);
        dfs(board, x, y - 1, m, n);
    }
}
