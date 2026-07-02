class Solution {
    public String removeOuterParentheses(String s) {
        int level = 0;
        StringBuilder ans= new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '('){
                if(level > 0) ans.append(c);
                level ++;
            }
            else if(c == ')'){
                level --;

                if(level >0) ans.append(c);
            }
        }
        return ans.toString();
    }
}