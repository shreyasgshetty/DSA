class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return calc(nums,k) - calc(nums,k-1);
    }
    public int calc(int[] nums, int goal){
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;

        if(goal<0) return 0;

        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>goal){
                sum-=nums[l]%2;
                l++;
            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }
}