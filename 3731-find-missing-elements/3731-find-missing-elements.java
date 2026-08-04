class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();

        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
            st.add(num);
        }

        for(int i = min; i <= max; i++){
            if(!st.contains(i)) ans.add(i);
        }
        return ans;
    }
}