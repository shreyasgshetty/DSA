class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int height[] = new int[matrix[0].length];

        for(int i = 0; i < matrix[0].length;i++){
            height[i] = 0;
        }

        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            int area = largestRectangleArea(height);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }

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