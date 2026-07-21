class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            HashSet<Character> hp = new HashSet<>();
            for(int j = i; j < s.length();j++){
                if(hp.contains(s.charAt(j))) break;
                int len = j-i+1;
                max = Math.max(max,len);
                hp.add(s.charAt(j));
            }
        }
        return max;
    }
}