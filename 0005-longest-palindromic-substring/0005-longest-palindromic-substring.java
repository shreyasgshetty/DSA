class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            for(int j=i+ans.length(); j<s.length(); j++){
                if (isPalindrome(s, i, j)) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s, int left, int right) {
        

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}