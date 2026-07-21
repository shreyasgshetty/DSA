import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0;
        int r = 0;

        int arr[] = new int[256];
        Arrays.fill(arr,-1);
        while(r<s.length()){
            if(arr[s.charAt(r)]!=-1){
                if(arr[s.charAt(r)] >= l){
                    l = arr[s.charAt(r)] + 1;
                }
            }
            int len = r - l + 1;
            max = Math.max(len,max);
            arr[s.charAt(r)] = r;
            r++;
        }
        
        return max;
    }
}