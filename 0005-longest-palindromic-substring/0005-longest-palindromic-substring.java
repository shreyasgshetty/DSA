class Solution {

    public String longestPalindrome(String s) {

        if(s.length() <= 1)
            return s;

        int start = 0;
        int maxLen = 1;

        for(int i = 0; i < s.length(); i++){

            for(int j = i + maxLen; j < s.length(); j++){

                if(isPalindrome(s, i, j)){
                    start = i;
                    maxLen = j - i + 1;
                }

            }
        }

        return s.substring(start, start + maxLen);
    }

    public boolean isPalindrome(String s, int left, int right){

        while(left < right){

            if(s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}