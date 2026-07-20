class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        int m = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if(!st.isEmpty() && st.peekLast()<=i-k){
                st.removeLast();
            }
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            st.push(i);

            if(i>=k-1) ans[m++] = nums[st.getLast()];
        }
        return ans;

    }

}