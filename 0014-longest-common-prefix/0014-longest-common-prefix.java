class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        String ans = "";

        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            minLength = Math.min(minLength, s.length());
        }

        for(int i = 0; i < minLength; i++){
            if(iscommon(first.charAt(i), strs, i)){
                ans += first.charAt(i);
            }
            else {
                break;
            }
        }
        return ans;
    }

    public boolean iscommon(char c, String[] strs, int n){
        for(int i = 1; i < strs.length; i++){   
            String word = strs[i];
            if (n >= word.length() || word.charAt(n) != c) {
                return false;
            }
        }
        return true;
    }
}