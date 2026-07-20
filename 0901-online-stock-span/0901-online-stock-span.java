class StockSpanner {

    Deque<int[]> st;
    int index = -1;

    public StockSpanner() {
        st = new ArrayDeque<>();
        index = -1;
    }

    
    public int next(int price) {
        int ans = 0;
        index = index + 1;
        while(!st.isEmpty() && st.peek()[0]<=price){
            st.pop();
        }
        ans = index - (st.isEmpty()?-1:st.peek()[1]);
        st.push(new int[] {price,index});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */