class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    count++;
                    dfs(n,m,i,j,grid,vis,drow,dcol);
                }
            }
        }
        return count;
    }

    public void dfs(int n, int m, int row, int col, char[][] grid, int[][] vis, int[] drow, int[] dcol){
        vis[row][col]=1;

        for(int i = 0; i < 4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                dfs(n,m,nrow,ncol,grid,vis,drow,dcol);
            }
        }
    }
}