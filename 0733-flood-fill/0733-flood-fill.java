class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialcolor = image[sr][sc];
        int[][] ans = image;
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};
        dfs(image,ans,sr,sc,dcol,drow,color,initialcolor);
        return ans;
    }

    public void dfs(int[][] image,int[][] ans, int row, int col,int[] dcol, int[] drow, int color, int initialcolor){
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i = 0; i < 4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && ans[nrow][ncol]!=color && image[nrow][ncol]==initialcolor){
                dfs(image,ans,nrow,ncol,dcol,drow,color,initialcolor);
            }
        }
    }
}