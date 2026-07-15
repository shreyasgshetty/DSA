class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        for(int i = 0; i<n;i++){
            ans[i] = -1;
            for(int j = i+1; j<i+n;j++){
                int ind = j%n;
                if(nums[ind] > nums[i]){
                    ans[i] = nums[ind];
                    break;
                }
            }
        }
        return ans;
    }
}