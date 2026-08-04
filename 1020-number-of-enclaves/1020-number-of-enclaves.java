class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};
        int[][] vis = new int[n][m];

        for(int j = 0; j < m; j++){
            if(grid[0][j]==1 && vis[0][j]==0){
                dfs(n,m,0,j,grid,vis,drow,dcol);
            }
            if(grid[n-1][j]==1 && vis[n-1][j]==0){
                dfs(n,m,n-1,j,grid,vis,drow,dcol);
            }
        }

        for(int i = 0; i < n; i++){
            if(grid[i][0]==1 && vis[i][0]==0){
                dfs(n,m,i,0,grid,vis,drow,dcol);
            }
            if(grid[i][m-1]==1 && vis[i][m-1]==0){
                dfs(n,m,i,m-1,grid,vis,drow,dcol);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int n, int m, int row, int col, int[][] grid, int[][] vis, int[] drow, int[] dcol){
        vis[row][col] = 1;

        for(int i = 0; i < 4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(n,m,nrow,ncol,grid,vis,drow,dcol);
            }
        }
    }
}