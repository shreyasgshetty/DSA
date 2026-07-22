import java .util.*;
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int hash[] = new int[256];
        Arrays.fill(hash,0);
        int l = 0;
        int r = 0;
        int sindex = -1;
        int count = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < m; i++){
            hash[t.charAt(i)]++;
        }
        while(r<s.length()){
            if(hash[s.charAt(r)]>0) count++;
            hash[s.charAt(r)]--;
            

            while(count==m){
                if(r-l+1 < min){
                    min = r-l+1;
                    sindex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) count--;
                l++;
            }
            r++;

        }
        return sindex==-1?"":s.substring(sindex,sindex+min);
    }
}