class Solution {
    public boolean check(int[] nums) {
        int breaks = 0;
        for(int i = 0; i < nums.length; i++){
            int next = (i+1)%nums.length;
            if(nums[i]>nums[next]) breaks++;
        }
        return breaks<=1;
    }
}