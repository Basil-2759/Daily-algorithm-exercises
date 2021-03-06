package com.offer.mid;

public class RoadOfMatrix {
    public static void main(String[] args) {
        RoadOfMatrix roadOfMatrix=new RoadOfMatrix();
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] a={{'a'}};
        char[][] abcd={{'a','b'},{'c','d'}};
        char[][] caa={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        System.out.println(roadOfMatrix.exist(caa,"AAB"));
//        System.out.println(roadOfMatrix.existttt(abcd,"acdb"));
    }

    public boolean exist(char[][] board, String word) {
        if (board==null||board.length==0||word==null || board[0].length == 0){
            return false;
        }
        int[][] flag=new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board,flag,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board, int[][] flag,String word,int x,int y,int index){
        if (index==word.length()){
            return true;
        }
        if (x<0||y<0||x>=board.length||y>=board[0].length){
            return false;
        }
        if (board[x][y]==word.charAt(index)&&flag[x][y]!=1){
            flag[x][y]=1;
            index++;
            boolean a=search(board,flag,word,x+1,y,index);
            boolean b=search(board,flag,word,x,y+1,index);
            boolean c=search(board,flag,word,x,y-1,index);
            boolean d=search(board,flag,word,x-1,y,index);
            if (a==true||b==true||c==true||d==true){
                return true;
            }
        }else {
            return false;
        }
        flag[x][y]=0;
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
                // ??? (0, 0) ??????????????? dfs ???????????????????????????
                // ????????? (0, 0) ????????????????????????????????????????????? (0, 1) ???????????????
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
        boolean ans = false;
        ans = dfs(board, chars, visited, i + 1, j, start + 1)
                || dfs(board, chars, visited, i - 1, j, start + 1)
                || dfs(board, chars, visited, i, j + 1, start + 1)
                || dfs(board, chars, visited, i, j - 1, start + 1);
        visited[i][j] = false;
        return ans;
    }
}
