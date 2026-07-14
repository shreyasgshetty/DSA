class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        int n = 0;
        for(int i = 0; i < nums1.length;i++){
            for(int j = 0; j < nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    int ans1 = -1;
                    for(int x = j; x < nums2.length;x++){
                        if(nums2[j]<nums2[x]){
                            ans1 = nums2[x];
                            break;
                        }
                    }
                ans[n] = ans1;
                n++;
                }
            }
        }
        return ans;
    }
}