class Solution {
    public boolean check(int[] nums) {
        int x = 0;
        for(int i = 0; i < nums.length - 1 ; i++){
            if(nums[i] > nums[i+1]){
                x = i+1;
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int j = x; j < nums.length ; j++){
            list.add(nums[j]);
        }
        for(int j = 0; j < x; j++){
            list.add(nums[j]);
        }

        for(int j = 0; j < list.size()-1;j++){
            if(list.get(j)>list.get(j+1)) return false;
        }
        return true;

    }
}