class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],1);
            }
            else{
                int x = hm.get(nums[i]);
                hm.put(nums[i],x+1);
            }
        }

        int max = 0;

        for(int i = 0; i < nums.length; i++){
            if(hm.get(nums[i])>nums.length/2) max = nums[i];
        }
        return max;
    }
}