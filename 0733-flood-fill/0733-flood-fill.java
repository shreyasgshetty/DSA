class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int initialcolor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>(); 
        queue.offer(new Pair(sr,sc));
        visited[sr][sc] = color;
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};
        
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            image[r][c] = color;
            queue.poll();
            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]!=color && image[nrow][ncol]==initialcolor){
                    queue.offer(new Pair(nrow,ncol));
                    visited[nrow][ncol]=color;
                }
            }
        }

    return image;
    }
}