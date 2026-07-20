class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int nse = 0;
        int pse = 0;
        int ele = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                ele = st.pop();
                nse = i;
                pse = st.isEmpty()?-1:st.peek();
                ans = Math.max(ans,heights[ele] * (nse - pse - 1));

            }
            st.push(i);
        }

        while(!st.isEmpty()){
            ele = st.pop();
            nse = heights.length;
            pse = st.isEmpty()?-1:st.peek();
            ans = Math.max(ans,heights[ele] * (nse - pse - 1));

        }

        return ans;

    }
}