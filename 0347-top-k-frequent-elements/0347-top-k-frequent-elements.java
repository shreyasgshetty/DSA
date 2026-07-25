class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        int x = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            hash.put(nums[i],hash.getOrDefault(nums[i], 0)+1);
        }

        while(k>0){
            int max = 0;
            int maxkey = -1;

            for(int key: hash.keySet()){
                if(hash.get(key)>max){
                    max = hash.get(key);
                    maxkey = key;
                }
            }
            ans[x++] = maxkey;
            hash.remove(maxkey);
            k--;
        }
        return ans;
    }
}