class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < isConnected.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < isConnected.length;i++){
            for(int j = 0; j < isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }

        boolean visited[] = new boolean[isConnected.length];

        int provinces = 0;

        for(int i = 0; i < isConnected.length;i++){
            if(!visited[i]){
                provinces++;

                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i]=true;

                while(!queue.isEmpty()){
                    int node = queue.poll();

                    for(int n : adj.get(node)){
                        if(!visited[n]){
                            queue.offer(n);
                            visited[n]=true;
                        }
                    }
                }
            }
        }
        return provinces;
    }
}