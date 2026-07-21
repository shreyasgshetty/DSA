class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0;
        int r = 0;

        HashMap<Character,Integer> hm = new HashMap<>();
        while(r<s.length()){
            if(hm.containsKey(s.charAt(r))){
                if(hm.get(s.charAt(r)) >= l){
                    l = hm.get(s.charAt(r)) + 1;
                }
            }
            int len = r - l + 1;
            max = Math.max(len,max);
            hm.put(s.charAt(r),r);
            r++;
        }
        
        return max;
    }
}