class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        cs(1,k,n, 0,ans,ds);
        return ans;
    }

    private void cs(int num,int k, int n, int sum, List<List<Integer>> ans, List<Integer> ds ){
        if(ds.size() == k && sum == n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=num; i<10 ;i++){
            if(i > 10) break;
            ds.add(i);
            cs(i+1,k,n,sum+i,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}