class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n,"",ans,0,0);
        return ans;
    }
    public void generate(int n, String current, List<String> ans,int open, int close){
        if(current.length() == 2*n){
            ans.add(current);
            return;
        }
        
        if (open < n) {
        generate(n, current + '(', ans, open + 1, close);
        }

        if (close < open) {
            generate(n, current + ')', ans, open, close + 1);
        }

    }
}