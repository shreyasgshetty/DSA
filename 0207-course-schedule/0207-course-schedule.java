class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i]==0) queue.add(i);
        }

        List<Integer> topo = new ArrayList<>();

        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    queue.offer(it);
                }
            }
        }

        if(topo.size()==numCourses) return true;
        return false;
    }
}