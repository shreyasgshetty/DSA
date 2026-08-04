class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};
        int[][] vis = new int[n][m];

        for(int j = 0; j < m; j++){
            if(board[0][j]=='O' && vis[0][j]==0){
                dfs(n,m,0,j,board,vis,drow,dcol);
            }
            if(board[n-1][j]=='O' && vis[n-1][j]==0){
                dfs(n,m,n-1,j,board,vis,drow,dcol);
            }
        }

        for(int i = 0; i < n; i++){
            if(board[i][0]=='O' && vis[i][0]==0){
                dfs(n,m,i,0,board,vis,drow,dcol);
            }
            if(board[i][m-1]=='O' && vis[i][m-1]==0){
                dfs(n,m,i,m-1,board,vis,drow,dcol);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }

    public void dfs(int n, int m, int row, int col, char[][] board, int[][] vis, int[] drow, int[] dcol){
        vis[row][col] = 1;

        for(int i = 0; i < 4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(n,m,nrow,ncol,board,vis,drow,dcol);
            }
        }
    }
}