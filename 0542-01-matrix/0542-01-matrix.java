class Pair {
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] distance = new int[n][m];
        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>(); 
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){
                if(mat[i][j]==0){
                    queue.offer(new Pair(i,j,0));
                    visited[i][j]=1;
                } else visited[i][j]=0;
            }
        }

        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int d = queue.peek().dist;
            queue.poll();
            distance[r][c] = d;
            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && visited[nrow][ncol]==0){
                    visited[nrow][ncol]=1;
                    queue.offer(new Pair(nrow,ncol,d+1));
                }
            }
        }
        return distance;


    }
}