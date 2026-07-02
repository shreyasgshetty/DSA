class Solution {
    public String removeOuterParentheses(String s) {
        int level = 0;
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' && level < 1){
                level++;
            } else if(s.charAt(i) == '(' && level >= 1){
                ans += s.charAt(i);
                level++;
            } else if(s.charAt(i) == ')' && level == 1){
                level--;
            } else if(s.charAt(i) == ')' && level > 1){
                ans += s.charAt(i);
                level--;
            } else{
                continue;
            }
        }
        return ans;
    }
}