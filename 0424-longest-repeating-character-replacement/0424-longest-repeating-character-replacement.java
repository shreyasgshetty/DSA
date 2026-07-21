import java.util.Arrays;

class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int l = 0;
        int r = 0;
        int maxf = 0;

        int arr[] = new int[26];
        Arrays.fill(arr,0);

        while(r<s.length()){
            arr[s.charAt(r)-'A']++;
            maxf = Math.max(maxf,arr[s.charAt(r)-'A']);
            while((r-l+1)-maxf>k){
                arr[s.charAt(l)-'A']--;
                maxf = 0;
                for(int i = 0; i < 26; i++){
                    maxf = Math.max(maxf,arr[i]);
                }
                l++;
            }
            if((r-l+1)-maxf <= k){
                max = Math.max(max,r-l+1);
            }
            r++;
        }
        return max;
    }
}