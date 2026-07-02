class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String a = s.substring(i, j+1);
                if(isPalindrome(a) && ans.length() < a.length()){
                    ans = a;
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String a) {
        int i = 0;
        int j = a.length() - 1;

        while(i <= j){
            if(a.charAt(i) != a.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}