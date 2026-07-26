class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)=='('){ 
                min++; max++;
            } else if(s.charAt(i)==')') {
                min--; max--;
            } else {
                min--;
                max++;
            }

            if(min<0) min = 0;
            if(max<0) return false;
            i++;
        }
        return min==0?true:false;
    }
}