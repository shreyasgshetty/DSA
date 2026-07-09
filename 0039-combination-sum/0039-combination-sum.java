class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        cs(0,candidates, target, ans, ds);
        return ans;
    }

    public void cs(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds){
        if(index == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[index] <= target){
            ds.add(candidates[index]);
            cs(index, candidates, target - candidates[index], ans, ds);
            ds.remove(ds.size() - 1);
        }

        cs(index+1, candidates, target, ans, ds);
    }
}