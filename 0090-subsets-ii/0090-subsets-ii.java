import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        subset(0,nums,ans,ds);
        return ans;
    }

    private void subset(int index, int[] nums, List<List<Integer>> ans, List<Integer> ds){
        ans.add(new ArrayList<>(ds));
        for(int i = index; i < nums.length;i++){
            if(i!=index && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            subset(i+1, nums, ans, ds);
            ds.remove(ds.size() - 1);
            
        }
    }
}