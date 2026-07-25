class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        HashMap<Integer,Integer> hash = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> hash.get(a)-hash.get(b));


        for(int i = 0; i < nums.length; i++){
            hash.put(nums[i],hash.getOrDefault(nums[i], 0)+1);
        }

        for(int key: hash.keySet()){
            pq.offer(key);

            if(pq.size()>k) pq.poll();
        }

        for(int i = k-1; i >=0; i--){
            ans[i] = pq.poll();
        }


        
        return ans;
    }
}