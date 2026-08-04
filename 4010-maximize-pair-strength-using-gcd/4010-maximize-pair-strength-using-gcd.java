class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1; j < nums.length; j++){
                long gcd = findGcd(nums[i],nums[j]);
                long strength = ((long) nums[i] * nums[j])/(gcd*gcd);
                ans = Math.max(ans,strength);
            }
        }
        return ans;
    }

    public long findGcd(long n, long m){
        if(m==0) return n;
        return findGcd(m,n%m);
    }
}